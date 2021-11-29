from flask import Blueprint, render_template
from flask_login import login_required
from flaskapp.models import Employee
from flaskapp import log, bcrypt, db, seed
home = Blueprint('main', __name__, template_folder="templates")


@home.route('/')
def home_page():
	""" Home Page """
	log.info("Someone accessed home page ")

	admin = Employee.query.filter_by(username='admin').first()
	hashed_pass = bcrypt.generate_password_hash('admin').decode('utf-8')
	if not admin:
		seed.seed_db()
		db.session.add(Employee(
			email='admin@gmail.com',
			username='admin',
			first_name='admin',
			last_name='admin',
			dob='1998-12-12',
			password=hashed_pass,
			phone='1754325',
			address='admin',
			is_admin=True
		))
		db.session.commit()


	return render_template('main.html', title='Home Page')


@home.route('/profile')
@login_required
def profile_page():
	""" Employee Profile Page """
	log.info("Profile Page accessed ")
	return render_template('profile.html', title='Profile Page')


@home.route('/dashboard')
@login_required
def dashboard():
	""" Employee Dashboard """
	log.info("Employee Dashboard Page")
	return render_template('dashboard.html', title='Dashboard')



