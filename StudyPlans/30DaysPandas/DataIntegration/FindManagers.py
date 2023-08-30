import pandas as pd

def find_managers(employee: pd.DataFrame) -> pd.DataFrame:
    # Get the counts of unique manager ids
    manager_counts = employee["managerId"].value_counts()
    # Filter the counts by those greater than 4
    manager_ids = manager_counts[manager_counts > 4].index
    # Set the employee id as the index of the employee names
    employee_names = employee.set_index("id")["name"]
    # Filter the employee names by those whose id is in the manager ids
    return employee_names[employee_names.index.isin(manager_ids)].to_frame(name="name")
