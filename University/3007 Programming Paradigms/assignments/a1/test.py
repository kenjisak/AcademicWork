# Kenji Isak Laguan 101160737
import sys

def convert_snake_case_string_to_list_of_words(snake_case_string):
	if snake_case_string == "":
		return []
	elif snake_case_string[0] == "_":
		return [snake_case_string[1]] + convert_snake_case_string_to_list_of_words(snake_case_string[2:])
	else:
		return [snake_case_string[0]] + convert_snake_case_string_to_list_of_words(snake_case_string[1:])
			
def main():
	print("\nSnake Case String: ", sys.argv[1]) # displays the arg input
	print("   Converted Alfa: ",convert_snake_case_string_to_list_of_words(sys.argv[1])) 
main()

