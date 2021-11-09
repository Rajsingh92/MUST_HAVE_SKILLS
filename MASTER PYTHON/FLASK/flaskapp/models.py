from flask_login import UserMixin
from flaskapp import db, login_manager


@login_manager.user_loader
def load_user(user_id):
	return Employee.query.get(int(user_id))


class Employee(db.Model, UserMixin):
	__tablename__ = 'employees'
	__searchable__ = ['email', 'username', 'first_name', 'last_name']

	id = db.Column(
		db.Integer,
		primary_key=True
	)
	email = db.Column(
		db.String(120),
		unique=True,
		nullable=False
	)
	username = db.Column(
		db.String(20),
		unique=True,
		nullable=False
	)
	first_name = db.Column(
		db.String(60),
		index=True
	)
	last_name = db.Column(
		db.String(60),
		index=True
	)
	dob = db.Column(
		db.Date,
		default=False
	)
	password = db.Column(
		db.String(60),
		nullable=False
	)
	phone = db.Column(
		db.String(60),
		nullable=False
	)
	address = db.Column(
		db.String(120),
		nullable=False
	)
	department_id = db.Column(
		db.Integer,
		db.ForeignKey('departments.id')
	)
	role_id = db.Column(
		db.Integer,
		db.ForeignKey('roles.id')
	)
	is_admin = db.Column(
		db.Boolean,
		default=False
	)

	def __repr__(self):
		return '<Employee: {}>'.format(self.username)


class Department(db.Model):
	__tablename__ = 'departments'

	id = db.Column(
		db.Integer,
		primary_key=True
	)
	name = db.Column(
		db.String(60),
		unique=True
	)
	employees = db.relationship(
		'Employee',
		backref='department',
		lazy='dynamic'
	)

	def __repr__(self):
		return '{}'.format(self.name)


class Role(db.Model):
	__tablename__ = 'roles'

	id = db.Column(
		db.Integer,
		primary_key=True
	)
	name = db.Column(
		db.String(60),
		unique=True
	)
	employees = db.relationship(
		'Employee',
		backref='role',
		lazy='dynamic'
	)

	def __repr__(self):
		return '{}'.format(self.name)


