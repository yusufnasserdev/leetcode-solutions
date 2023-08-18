import pandas as pd

def count_rich_customers(store: pd.DataFrame) -> pd.DataFrame:
    rich_bill = 500
    return pd.DataFrame(
        {
            "rich_count": [
                len(
                    store.query("amount > @rich_bill").drop_duplicates(
                        subset=["customer_id"]
                    )
                )
            ]
        }
    )
