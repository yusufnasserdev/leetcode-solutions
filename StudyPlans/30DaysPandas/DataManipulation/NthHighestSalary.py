import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    employee = employee['salary'].drop_duplicates().sort_values(ascending=False)
    return pd.DataFrame({'getNthHighestSalary({N})' : [employee.iloc[N-1] if N-1 < len(employee) else None]})

