from myobjectfactory import MyObjectFactory

myobj = MyObjectFactory.create_object('myclass')
if myobj:
    myobj.do_something('something')
else:
    print('Not doing anything.')
