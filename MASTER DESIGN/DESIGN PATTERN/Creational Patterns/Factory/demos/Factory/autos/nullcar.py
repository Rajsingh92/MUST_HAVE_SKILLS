from .abs_auto import AbsAuto

class NullCar(AbsAuto):

	def start(self):
		print ('Unknown car "%s".' % self.name)

	def stop(self):
		pass