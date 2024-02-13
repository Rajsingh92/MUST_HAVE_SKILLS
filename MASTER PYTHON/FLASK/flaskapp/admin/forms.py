from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from flaskapp.models import Department, Role
from wtforms.ext.sqlalchemy.fields import QuerySelectField
from wtforms.validators import DataRequired


class DepartmentForm(FlaskForm):
	name = StringField(
		'Name',
		validators=[DataRequired()]
	)
	submit = SubmitField('Submit')


class RoleForm(FlaskForm):
	name = StringField(
		'Name',
		validators=[DataRequired()]
	)
	submit = SubmitField('Submit')


class AssignDepartmentForm(FlaskForm):
	department = QuerySelectField(
		query_factory=lambda: Department.query.all(),
		get_label="name"
	)
	role = QuerySelectField(
		query_factory=lambda: Role.query.all(),
		get_label="name"
	)
	submit = SubmitField('Submit')


class SearchForm(FlaskForm):
	query = StringField(
		'query',
		validators=[DataRequired()]
	)
	submit = SubmitField('Submit')

