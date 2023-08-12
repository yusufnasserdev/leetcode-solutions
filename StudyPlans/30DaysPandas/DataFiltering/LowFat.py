import pandas as pd

def find_products(products: pd.DataFrame) -> pd.DataFrame:
    yes = 'Y'
    return products.query('low_fats == @yes and recyclable == @yes').drop(columns = ['recyclable','low_fats'])