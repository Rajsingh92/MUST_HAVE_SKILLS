import numpy as np
from sklearn.linear_model import LinearRegression, LogisticRegression, Ridge, Lasso, ElasticNet, RidgeClassifier, SGDClassifier, BayesianRidge
from sklearn.svm import SVC, SVR
from sklearn.neighbors import KNeighborsRegressor, KNeighborsClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.tree import DecisionTreeClassifier, DecisionTreeRegressor
from sklearn.cluster import DBSCAN, MeanShift, KMeans, AffinityPropagation
from sklearn.ensemble import RandomForestClassifier, RandomForestRegressor, ExtraTreesClassifier, ExtraTreesRegressor
from sklearn.ensemble import GradientBoostingClassifier, GradientBoostingRegressor, AdaBoostRegressor, AdaBoostClassifier
from lightgbm import LGBMClassifier, LGBMRegressor
from catboost import CatBoostClassifier, CatBoostRegressor
from xgboost import XGBClassifier, XGBRegressor
from sklearn.decomposition import PCA, IncrementalPCA,KernelPCA,TruncatedSVD,LatentDirichletAllocation
from sklearn.feature_extraction.text import CountVectorizer, TfidfVectorizer, HashingVectorizer
from sklearn.manifold import TSNE

CLASSIFICATION_MODELS = {
    "lr": LogisticRegression(random_state=42),
    "knn": KNeighborsClassifier(n_jobs=-1),
    "nb": GaussianNB(),
    "dtc": DecisionTreeClassifier(random_state=42),
    "svm": SGDClassifier(max_iter=1000, tol=0.001, random_state=42,  n_jobs=-1),
    "rbfsvm": SVC(gamma='auto', C=1, probability=True, kernel='rbf', random_state=42),
    "ridge": RidgeClassifier(random_state=42),
    "rfc": RandomForestClassifier(n_estimators=10, random_state=42, n_jobs=-1),
    "ada": AdaBoostClassifier(random_state=42),
    "gbc": GradientBoostingClassifier(random_state=42),
    "et": ExtraTreesClassifier(random_state=42, n_jobs=-1),
    "xgboost": XGBClassifier(random_state=42, verbosity=0,  n_jobs=-1),
    "lightgbm": LGBMClassifier(random_state=42,  n_jobs=-1),
    "catboost": CatBoostClassifier(random_state=42, silent=True),
}

REGRESSION_MODELS = {
    "lr": LinearRegression(n_jobs=-1),
    "ridge": Ridge(random_state=42),
    "lasso": Lasso(random_state=42),
    "en": ElasticNet(random_state=42),
    "br": BayesianRidge(),
    "svm": SVR(),
    "knn":  KNeighborsRegressor(n_jobs=-1),
    "dtr": DecisionTreeRegressor(random_state=42),
    "rfr":  RandomForestRegressor(random_state=42, n_jobs=-1),
    "et": ExtraTreesRegressor(random_state=42, n_jobs=-1),
    "ada": AdaBoostRegressor(random_state=42),
    "gbr": GradientBoostingRegressor(random_state=42),
    "xgboost": XGBRegressor(random_state=42, n_jobs=-1, verbosity=0),
    "lightgbm": LGBMRegressor(random_state=42, n_jobs=-1),
    "catboost": CatBoostRegressor(random_state=42, silent=True, thread_count=-1),
}


CLUSTERING_MODELS = {
    "kmeans": KMeans(n_clusters=4, random_state=42, n_jobs=-1),
    "ap": AffinityPropagation(),
    "meanshift": MeanShift(n_jobs=-1),
    "dbscan": DBSCAN(n_jobs=-1)
}



NLP_MODELS = {
    "ctv": CountVectorizer(
        analyzer='word',
        token_pattern=r'\w{1,}',
        ngram_range=(1, 3),
        stop_words='english'
    ),
    "tfv": TfidfVectorizer(
        min_df=3,
        max_features=None,
        strip_accents='unicode',
        analyzer='word',
        token_pattern=r'\w{1,}',
        ngram_range=(1, 3),
        use_idf=1,
        smooth_idf=1,
        sublinear_tf=1,
        stop_words='english'
    ),
    "hv": HashingVectorizer(
        dtype=np.float32,
        strip_accents='unicode',
        analyzer='word',
        ngram_range=(1, 4),
        n_features=2**12,
        non_negative=True
    ),
}


DIMENSIONALITY_REDUCTION = {
    "pca":  PCA(n_components=2),
    "kpca" : KernelPCA(),
    "ipca":  IncrementalPCA(n_components=2, batch_size=10),
    "tsvd" : TruncatedSVD(),
    "lda" : LatentDirichletAllocation(),
    "tsne" : TSNE()
}


