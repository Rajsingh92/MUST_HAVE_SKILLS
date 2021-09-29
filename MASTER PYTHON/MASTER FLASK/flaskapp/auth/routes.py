from flask import Blueprint, render_template, flash, redirect, url_for
from flaskapp import bcrypt, log
from flaskapp.auth.forms import LoginForm, RegisterForm
from flask_login import login_user, logout_user, login_required, current_user
from flaskapp.models import Employee, db

auth = Blueprint('auth', __name__, template_folder="templates")


@auth.route('/login', methods=['GET', 'POST'])
def login():
	""" login """
	if current_user.is_authenticated:
		if current_user.is_admin:
			return redirect(url_for('admin.adminpage'))
		return redirect(url_for('main.dashboard'))

	form = LoginForm()

	if form.validate_on_submit():
		user = Employee.query.filter_by(email=form.email.data).first()

		if user and bcrypt.check_password_hash(user.password, form.password.data):
			login_user(user)
			log.info(f'{user.username} logged in')
			if user.is_admin:
				flash("Welcome admin", "success")
				return redirect(url_for('admin.adminpage'))
			else:
				flash("Welcome to Nagarro", "success")
				return redirect(url_for('main.dashboard'))
		else:
			flash("please enter valid email and password", "danger")
	return render_template('login.html', title='Login Page', form=form)


@auth.route('/register', methods=['GET', 'POST'])
def register():
	""" register """
	form = RegisterForm()

	if form.validate_on_submit():
		# validate email and username
		# user_email = Employee.query.filter_by(email=form.email.data).first()
		# user_username = Employee.query.filter_by(username=form.username.data).first()
		#
		# if user_email:
		# 	flash("Email already exist", 'danger')
		# elif user_username:
		# 	flash("Username already exist", 'danger')
		# else:
		hashed_pass = bcrypt.generate_password_hash(form.password.data).decode('utf-8')
		employee = Employee(
			email=form.email.data,
			username=form.username.data,
			first_name=form.firstname.data,
			last_name=form.lastname.data,
			dob=form.dob.data,
			password=hashed_pass,
			phone=form.phone.data,
			address=form.address.data
		)

		db.session.add(employee)
		db.session.commit()
		log.info(f'Account created for {form.email.data}')
		flash(f'Account created for {form.email.data}', "success")
		return redirect(url_for('auth.login'))
	return render_template('register.html', title='Register Page', form=form)


@auth.route("/logout")
@login_required
def logout():
	""" logout """
	log.info(f"{current_user.username} logged out")
	logout_user()
	flash("logged out successfully", "success")
	return redirect(url_for('main.home_page'))
