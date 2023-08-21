import pandas as pd


def actors_and_directors(actor_director: pd.DataFrame) -> pd.DataFrame:
    df = actor_director[["actor_id", "director_id"]].value_counts().reset_index()
    df = df[df["count"] > 2]

    return df[["actor_id", "director_id"]]
