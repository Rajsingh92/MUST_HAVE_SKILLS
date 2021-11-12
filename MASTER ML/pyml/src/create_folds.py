import pandas as pd
import config
from sklearn.model_selection import KFold  
from sklearn.model_selection import StratifiedKFold  
from iterstrat.ml_stratifiers import MultilabelStratifiedKFold   
import argparse

FOLD_METHOD ={
    "kf" : KFold(n_splits=5,shuffle=False,random_state=42),
    "skf" : StratifiedKFold(n_splits=5,shuffle=False,random_state=42),
    "mlskf" : MultilabelStratifiedKFold(n_splits=5,shuffle=False,random_state=42)
}

if __name__ == "__main__":
    
    df = pd.read_csv(config.TRAINING_FILE)  #dataframe
    y = df.Species.values #target

    df["kfold"] = -1

    df = df.sample(frac=1).reset_index(drop=True)

    kf = FOLD_METHOD['skf']

    for fold, (train_idx, val_idx) in enumerate(kf.split(X=df, y=y)):  #remove y for kfold
        print(len(train_idx), len(val_idx))
        df.loc[val_idx, 'kfold'] = fold
    
    df.to_csv("../input/train_folds.csv", index=False)
