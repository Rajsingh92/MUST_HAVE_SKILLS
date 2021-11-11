from flask import Flask
from flask_login import LoginManager
from flask_bcrypt import Bcrypt
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from flaskapp.functions import init_log
from flask_restful import Api
from flaskapp.config import Config

db = SQLAlchemy()
login_manager = LoginManager()
bcrypt = Bcrypt()
api = Api()
log = init_log('my_logs')


def register_extensions(app):
    db.init_app(app)
    bcrypt.init_app(app)
    login_manager.init_app(app)
    login_manager.login_message = "You are not authorised to see this page. Please log in"
    login_manager.login_message_category = 'info'
    login_manager.login_view = "auth.login"
    api.init_app(app)


def register_blueprints(app):
    from flaskapp.main.routes import home
    from flaskapp.auth.routes import auth
    from flaskapp.admin.routes import admin
    app.register_blueprint(home)
    app.register_blueprint(auth)
    app.register_blueprint(admin, url_prefix='/admin')


def register_errors(app):
    from flaskapp import errors
    app.register_error_handler(403, errors.forbidden)
    app.register_error_handler(404, errors.page_not_found)
    app.register_error_handler(500, errors.internal_server_error)


def create_app():
    app = Flask(__name__)
    app.config.from_object(Config)

    register_extensions(app)
    migrate = Migrate(app, db)
    register_blueprints(app)
    register_errors(app)

    from flaskapp import models
    with app.app_context():
        db.create_all()

    return app


