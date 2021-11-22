from .abs_auto import AbsAuto

class ChevyVolt(AbsAuto):

	def start(self):
		print('%s running with shocking power!' % self.name)

	def stop(self):
		print('%s shutting down.' % self.name)