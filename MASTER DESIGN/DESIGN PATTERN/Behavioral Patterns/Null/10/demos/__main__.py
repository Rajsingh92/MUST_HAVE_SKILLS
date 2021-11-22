from myobjectfactory import MyObjectFactory

myobj = MyObjectFactory.create_object('myotherlass')
myobj.do_something('something')
# if myobj is not None:
#     myobj.do_something('something')
# else:
#     print('Not doing anything.')
