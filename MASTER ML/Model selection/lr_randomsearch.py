from sklearn.datasets import load_digits
import pandas as pd
import numpy as np
from sklearn.model_selection import RandomizedSearchCV
from sklearn.linear_model import LogisticRegression

if __name__ == "__main__":
    X, y = load_digits(n_class=10, return_X_y=True)
    clf = LogisticRegression()

    param_grid = {'C': np.arange(0, 10),
                  "penalty": ['l1', 'l2'],
                  "class_weight": ["balanced", None]
                  }

    model = RandomizedSearchCV(
        estimator=clf,
        param_distributions=param_grid,
        cv=10,
        verbose=10,
        n_jobs=1,
        scoring="accuracy",
        n_iter= 10
    )

    model.fit(X, y)
    print(f"Best score: {model.best_score_}")

    print("Best parameters set:")
    best_parameters = model.best_estimator_.get_params()
    for param_name in sorted(param_grid.keys()):
        print(f"\t{param_name}: {best_parameters[param_name]}")
