import pandas as pd


def count_salary_categories(accounts: pd.DataFrame) -> pd.DataFrame:
    low = len(accounts[accounts["income"] < 20000])
    high = len(accounts[accounts["income"] > 50000])

    return pd.DataFrame(
        {
            "category": ["Low Salary", "Average Salary", "High Salary"],
            "accounts_count": [low, len(accounts) - (high + low), high],
        }
    )
