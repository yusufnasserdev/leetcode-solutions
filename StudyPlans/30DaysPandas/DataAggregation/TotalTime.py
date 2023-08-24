import pandas as pd


def total_time(employees: pd.DataFrame) -> pd.DataFrame:
    employees["total_time"] = employees["out_time"] - employees["in_time"]
    employees = employees.drop(columns=["in_time", "out_time"], axis=1)
    employees = (
        employees.groupby(["event_day", "emp_id"])["total_time"].sum().reset_index()
    )
    return employees.rename(columns={"event_day": "day"})
