from flask_wtf import FlaskForm
from flaskapp.models import Employee
from wtforms import StringField, PasswordField, SubmitField, TextAreaField, DateField
from wtforms.validators import DataRequired, EqualTo, Email, Length, ValidationError


class LoginForm(FlaskForm):
	email = StringField(
		'Email',
		validators=[DataRequired(), Email()]
	)
	password = PasswordField(
		'Password',
		validators=[DataRequired()]
	)
	submit = SubmitField('Login')


class RegisterForm(FlaskForm):
	email = StringField(
		'Email',
		validators=[DataRequired(), Email()]
	)
	username = StringField(
		'Username',
		validators=[DataRequired()]
	)
	firstname = StringField(
		'First Name',
		validators=[DataRequired()]
	)
	lastname = StringField(
		'Last Name',
		validators=[DataRequired()]
	)
	password = PasswordField(
		'Password',
		validators=[DataRequired()]
	)
	dob = DateField(
		'dob',
		validators=[DataRequired()]
	)
	confirm_password = PasswordField(
		'Confirm Password',
		validators=[DataRequired(), EqualTo('password')]
	)
	phone = StringField(
		'Phone',
		validators=[DataRequired()]
	)
	address = TextAreaField(
		'Address',
		validators=[DataRequired(), Length(max=200)]
	)
	submit = SubmitField('Sign up')

	def validate_username(self, username):
		user_username = Employee.query.filter_by(username=username.data).first()
		if user_username:
			raise ValidationError('Username already exist')

	def validate_email(self, email):
		user_email = Employee.query.filter_by(email=email.data).first()
		if user_email:
			raise ValidationError('Email already exist')