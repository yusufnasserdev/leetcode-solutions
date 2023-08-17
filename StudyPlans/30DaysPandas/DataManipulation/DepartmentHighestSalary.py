import pandas as pd


def department_highest_salary(
    employee: pd.DataFrame, department: pd.DataFrame
) -> pd.DataFrame:
    employee = employee[ employee.groupby(by="departmentId")['salary'].transform(max) == employee['salary']]
    
    department = dict(department[['id', 'name']].values)
    
    employee["departmentId"] = employee["departmentId"].map(department)
    employee = employee.rename(
        columns={"departmentId": "Department", "salary": "Salary", "name": "Employee"}
    )
    employee = employee.reindex(columns=["Department", "Employee", "Salary"])
    
    return employee