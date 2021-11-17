import os


class Config:
	SECRET_KEY = '5791628bb0b13ce0c676dfde280ba245'
	SQLALCHEMY_DATABASE_URI = 'mysql://root:root@db/flaskapp'
	SQLALCHEMY_TRACK_MODIFICATIONS = False

