# Kenji Isak Laguan 101160737
import sys

def convert_to_list(list,string):
	# if nothing in string then return list
	# elif its _ then add the next char as list element instead, run again past char
	# else its just normal char then add it at the end of the last element in the list, run again past char
	if not string:
		return list 
	elif string[0] == "_":
		list += [string[1]]
		return convert_to_list(list,string[2:])
	else:
		list[-1] += string[0]
		return convert_to_list(list,string[1:])

def convert_one_word_to_alfa(string):
	# if nothing in string then return space
	# elif char is vowel add vowel,f,vowel,space to rest of word
	# else char is consonant or space then append char to rest of word
	if not string:
		return " "
	elif string[0] in ("aeiou"):
		return string[0] + "f" + string[0] + " " + convert_one_word_to_alfa(string[1:])
	else:
		return string[0] + convert_one_word_to_alfa(string[1:])

def use_functions_return_all_alfa(list):
	# if nothing in list then return empty string
	# else list has word then converted word of the first element of the list added with remaining words in list
	if not list:
		return ""
	else:
		return convert_one_word_to_alfa(list[0]) + use_functions_return_all_alfa(list[1:]) 
 
def main():
	print("\nSnake Case String: ", sys.argv[1]) # displays the arg input
	print("   Converted Alfa: ",use_functions_return_all_alfa(convert_to_list([""],sys.argv[1]))) # runs conversion with given arg

main()