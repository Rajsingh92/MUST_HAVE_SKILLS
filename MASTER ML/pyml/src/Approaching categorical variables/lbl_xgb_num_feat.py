# lbl_xgb_num_feat.py
import itertools
import pandas as pd
import xgboost as xgb
from sklearn import metrics
from sklearn import preprocessing
def feature_engineering(df, cat_cols):
"""
This function is used for feature engineering
:param df: the pandas dataframe with train/test data
:param cat_cols: list of categorical columns
:return: dataframe with new features
"""
# this will create all 2-combinations of values
# in this list
# for example:
# list(itertools.combinations([1,2,3], 2)) will return
# [(1, 2), (1, 3), (2, 3)]
combi = list(itertools.combinations(cat_cols, 2))
for c1, c2 in combi:
df.loc[
:,
c1 + "_" + c2
] = df[c1].astype(str) + "_" + df[c2].astype(str)
return df
def run(fold):
# load the full training data with foldsApproaching (Almost) Any Machine Learning Problem
130
df = pd.read_csv("../input/adult_folds.csv")
# list of numerical columns
num_cols = [
"fnlwgt",
"age",
"capital.gain",
"capital.loss",
"hours.per.week"
]
# map targets to 0s and 1s
target_mapping = {
"<=50K": 0,
">50K": 1
}
df.loc[:, "income"] = df.income.map(target_mapping)
# list of categorical columns for feature engineering
cat_cols = [
c for c in df.columns if c not in num_cols
and c not in ("kfold", "income")
]
# add new features
df = feature_engineering(df, cat_cols)
# all columns are features except kfold & income columns
features = [
f for f in df.columns if f not in ("kfold", "income")
]
# fill all NaN values with NONE
# note that I am converting all columns to "strings"
# it doesnt matter because all are categories
for col in features:
# do not encode the numerical columns
if col not in num_cols:
df.loc[:, col] = df[col].astype(str).fillna("NONE")
# now its time to label encode the features
for col in features:
if col not in num_cols:
# initialize LabelEncoder for each feature column
lbl = preprocessing.LabelEncoder()
# fit label encoder on all dataApproaching (Almost) Any Machine Learning Problem
131
lbl.fit(df[col])
# transform all the data
df.loc[:, col] = lbl.transform(df[col])
# get training data using folds
df_train = df[df.kfold != fold].reset_index(drop=True)
# get validation data using folds
df_valid = df[df.kfold == fold].reset_index(drop=True)
# get training data
x_train = df_train[features].values
# get validation data
x_valid = df_valid[features].values
# initialize xgboost model
model = xgb.XGBClassifier(
n_jobs=-1
)
# fit model on training data (ohe)
model.fit(x_train, df_train.income.values)
# predict on validation data
# we need the probability values as we are calculating AUC
# we will use the probability of 1s
valid_preds = model.predict_proba(x_valid)[:, 1]
# get roc auc score
auc = metrics.roc_auc_score(df_valid.income.values, valid_preds)
# print auc
print(f"Fold = {fold}, AUC = {auc}")
if __name__ == "__main__":
for fold_ in range(5):
run(fold_)