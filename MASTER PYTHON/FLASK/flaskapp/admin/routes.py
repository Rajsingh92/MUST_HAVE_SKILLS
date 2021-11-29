from flask import render_template, abort, make_response, flash, url_for, redirect, request
from flask_login import login_required
from flask_restful import Resource, Api
from flaskapp import db, log
from flaskapp.admin.forms import DepartmentForm, RoleForm, AssignDepartmentForm, SearchForm
from flaskapp.models import Department, Role, Employee
from . import admin, admin_required

api = Api(admin)


class AdminPage(Resource):
	""" Admin Dashboard """
	decorators = [login_required, admin_required]

	def get(self):
		headers = {'Content-Type': 'text/html'}
		log.info("admin dashboard accessed")
		return make_response(render_template('admin_dashboard.html', title='Auth Page'), 200, headers)


api.add_resource(AdminPage, '/dashboard')


@admin.route('/employees')
@login_required
@admin_required
def list_employees():
	""" Get Employees List"""
	employees = Employee.query.all()
	log.info("admin has asked for list of employees")
	return render_template('employees.html', title='Employees List', employees=employees)


@admin.route('/employees/delete/<int:id>', methods=['GET', 'POST'])
@login_required
@admin_required
def delete_employee(id):
	""" DELETE EMPLOYEE WITH ID"""
	employee = Employee.query.get_or_404(id)

	if employee.is_admin:
		abort(403)

	db.session.delete(employee)
	db.session.commit()
	flash("Employee Deleted Successfully", "success")
	log.info(f'admin has deleted account of { employee.username }')
	return redirect(url_for('admin.list_employees'))


@admin.route('/employees/assign/<int:id>', methods=['GET', 'POST'])
@admin_required
def assign_department_to_employee(id):
	""" Assign Department To Employee With Id"""
	employee = Employee.query.get_or_404(id)

	if employee.is_admin:
		abort(403)

	form = AssignDepartmentForm(obj=employee)

	if form.validate_on_submit():
		employee.department = form.department.data
		employee.role = form.role.data

		db.session.add(employee)
		db.session.commit()

		flash("Updated Successfully", 'success')
		log.info(f'admin has assigned department { employee.department } and role { employee.role } to { employee.username }')
		return redirect(url_for('admin.list_employees'))
	return render_template('assign_department.html', title="Assign Department", form=form)


@admin.route('/departments')
@admin_required
@login_required
def list_departments():
	departments = Department.query.all()
	log.info("admin has asked for list of departments")
	return render_template('departments.html', title='Departments List', departments=departments)


@admin.route('/departments/add', methods=['GET', 'POST'])
@admin_required
@login_required
def add_department():
	""" Add Department """
	form = DepartmentForm()

	if form.validate_on_submit():
		department = Department(name=form.name.data)
		try:
			db.session.add(department)
			db.session.commit()
			flash('Department Added Successfully', 'success')
			log.info(f"Department {department.name} added to database")
		except:
			log.error("Department already exist")
			flash('Error : Department already Exist', 'danger')

		return redirect(url_for('admin.list_departments'))

	return render_template('add_department.html', form=form, title='Add Department')


@admin.route('/departments/edit/<int:id>', methods=['GET', 'POST'])
@login_required
@admin_required
def edit_department(id):
	""" Edit Department """
	department = Department.query.get_or_404(id)
	prev = department.name
	form = DepartmentForm(obj=department)

	if form.validate_on_submit():
		department.name = form.name.data
		db.session.commit()
		flash("Department edited successfully", "success")
		log.info(f"Department { prev } changed to { department.name }")
		return redirect(url_for('admin.list_departments'))
	return render_template('edit_department.html', form=form, title='Edit Department', dname=department.name)


@admin.route('/departments/delete/<int:id>', methods=['GET', 'POST'])
def delete_department(id):
	""" Delete Department """
	department = Department.query.get_or_404(id)

	db.session.delete(department)
	db.session.commit()
	flash("Department Deleted Successfully", "success")
	log.info(f"{department.name} deleted ")
	return redirect(url_for('admin.list_departments'))


@admin.route('/roles')
@admin_required
@login_required
def list_roles():
	""" Roles List"""
	roles = Role.query.all()
	log.info("admin has asked for list of roles")
	return render_template('roles.html', title='Roles List', roles=roles)


@admin.route("roles/delete/<int:id>", methods=['GET', 'POST'])
@login_required
@admin_required
def delete_role(id):
	""" Delete Role """
	role = Role.query.get_or_404(id)

	db.session.delete(role)
	db.session.commit()
	flash("Role Deleted Successfully", "success")
	log.info(f"{ role.name } deleted")
	return redirect(url_for('admin.list_roles'))


@admin.route('/roles/add', methods=['GET', 'POST'])
@login_required
@admin_required
def add_role():
	""" Add Role """
	form = RoleForm()

	if form.validate_on_submit():
		try:
			role = Role(name=form.name.data)
			db.session.add(role)
			db.session.commit()
			flash("Role added successfully", 'success')
			log.info(f"{role.name} added to database")
		except:
			flash("Error : role already exist", 'danger')
			log.info("role already exist with this name")

		return redirect(url_for('admin.list_roles'))

	return render_template('add_role.html', form=form, title='Add Role')


@admin.route('/roles/edit/<int:id>', methods=['GET', 'POST'])
@login_required
@admin_required
def edit_role(id):
	""" Edit Role """
	role = Role.query.get_or_404(id)
	prev = role.name
	form = RoleForm(obj=role)

	if form.validate_on_submit():
		role.name = form.name.data
		db.session.commit()
		flash("Role edited successfully", "success")
		log.info(f"Role {prev} changed to { role.name }")
		return redirect(url_for('admin.list_roles'))
	return render_template('edit_role.html', form=form, title='Edit Role', rname=role.name)



