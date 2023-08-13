import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:   
    df = views.query('author_id == viewer_id')
    df = df[['author_id']].drop_duplicates().rename(columns={'author_id': 'id'})
    return df.sort_values(by=['id'])