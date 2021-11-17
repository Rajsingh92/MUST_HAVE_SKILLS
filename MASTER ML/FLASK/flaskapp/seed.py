from faker import Faker
from faker.providers.phone_number import Provider
from sqlalchemy.exc import IntegrityError
from flaskapp.models import Employee, Department, Role
from flaskapp import bcrypt, log, db

departments = [
		"Marketing",
		"Operations",
		"Finance",
		"Sales",
		"Human Resource",
		"Purchase",
	]

roles = [
		"Operations manager"
		"Accountant",
		"bookkeeper",
		"controller",
		"Office manager",
		"Receptionist",
		"Foreperson",
		"supervisor",
		"Marketing manager",
		"Purchasing manager",
	]


class IndiaPhoneNumberProvider(Provider):
	""" A Provider for phone number. """
	def india_phone_number(self):
		return f'+91 {self.msisdn()[3:]}'


def seed_db(num_of_employers=20):
	fake = Faker()
	fake.add_provider(IndiaPhoneNumberProvider)

	print("Creating Departments... ")
	log.info("Creating Departments... ")

	for department in departments:
		d = Department(name=department)
		db.session.add(d)
		try:
			db.session.commit()
		except IntegrityError:
			db.session.rollback()

	print("Finished creating Departments...")
	log.info("Finished creating Departments...")
	print("\n")

	print("Creating roles...")
	log.info("Creating roles...")

	for role in roles:
		r = Role(name=role)
		db.session.add(r)
		try:
			db.session.commit()
		except IntegrityError:
			db.session.rollback()

	print("Finished creating Roles...")
	log.info("Finished creating Roles...")
	print("\n")

	i = 0
	hashed_pass = bcrypt.generate_password_hash('pass').decode('utf-8')
	print("Creating employers...")
	log.info("Creating employers...")

	while i < num_of_employers:
		e = Employee(
			email=fake.email(),
			username=fake.name(),
			first_name=fake.name(),
			last_name=fake.name(),
			dob=fake.date_of_birth(),
			password=hashed_pass,
			phone=fake.india_phone_number(),
			address=fake.address(),
			department_id=1,
			role_id=1,
		)
		db.session.add(e)
		try:
			db.session.commit()
			i += 1
		except IntegrityError:
			db.session.rollback()

	print("Finished creating employers...")
	log.info("Finished creating employers...")


