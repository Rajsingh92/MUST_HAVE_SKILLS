def reverse_string(mystring):
    if len(mystring) == 0:
        return mystring
    else:
        return reverse_string(mystring[1:])+mystring[0]


print(reverse_string('raj'))