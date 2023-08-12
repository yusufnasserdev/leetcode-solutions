import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:    
    # Select the customers whose 'id' is not present in the orders DataFrame's 'customerId' column.
    df = views.query('author_id == viewer_id')

    # Build a DataFrame that only contains the 'name' column and rename it as 'Customers'.
    df = df[['author_id']].drop_duplicates().rename(columns={'author_id': 'id'})
    
    return df.sort_values(by=['id'])