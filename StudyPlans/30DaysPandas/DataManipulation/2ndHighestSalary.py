import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    employee = employee['salary'].drop_duplicates().sort_values(ascending=False)
    print(employee)
    return pd.DataFrame({'SecondHighestSalary' : [employee.iloc[1] if len(employee) > 1 else None]})