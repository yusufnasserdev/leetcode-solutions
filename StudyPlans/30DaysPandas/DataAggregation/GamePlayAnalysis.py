import pandas as pd


def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    return (
        activity.sort_values(by=["event_date"])
        .drop(columns=["games_played", "device_id"], axis=1)
        .drop_duplicates(subset=["player_id"])
        .rename(columns={"player_id": "first_login"})
    )
