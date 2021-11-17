from flask import render_template, request
from flaskapp import log


def forbidden(error):
	log.error('Forbidden : %s' % error)
	return render_template('errors/403.html', title='Forbidden')


def page_not_found(error):
	log.error('Page not found: %s', (request.path))
	return render_template('errors/404.html', title='Page Not Found')


def internal_server_error(error):
	log.error('Server Error: %s' % error)
	return render_template('errors/500.html', title='Server Error')
