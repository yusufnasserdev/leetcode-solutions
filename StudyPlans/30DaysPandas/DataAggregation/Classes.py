import pandas as pd


def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    return (
        courses["class"]
        .value_counts()[(courses["class"].value_counts() > 4)]
        .index.to_frame()
    )
