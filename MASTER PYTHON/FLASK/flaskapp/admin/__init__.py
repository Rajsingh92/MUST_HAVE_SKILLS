from flask import Blueprint, flash, redirect, url_for
from functools import wraps
from flask_login import current_user
from flaskapp import log

admin = Blueprint('admin', __name__, template_folder="templates")


def admin_required(f):
    @wraps(f)
    def _admin_required(*args, **kwargs):
        try:
            if not current_user.is_admin:
                flash("You need to be an administrator to access this page", "danger")
                return redirect(url_for("auth.login"))
            return f(*args, **kwargs)
        except:
            flash("You need to be an administrator to access this page", 'danger')
            log.info("Error : first login")
            return redirect(url_for("auth.login"))
    return _admin_required
