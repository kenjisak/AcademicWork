-- Kenji Isak Laguan 101160737
import Debug.Trace
type LastName = String
type PhoneNumber = String
type Entry = (LastName,PhoneNumber)
type Database = [Entry]

type SoundexCode = String

database :: Database
database = [("JOHN","613-323-5325"),("JON","613-324-2342"),("COLLIER","613-520-2600"),("COLYIER","613-520-3144"),("LILLY","613-123-3131"),("LLOYD","613-345-2542"),("LI","613-433-3442"),("LEE","613-413-7814")]

rmvfirst :: LastName -> String
rmvfirst (first:rest) = rest

soundex1 :: LastName -> [Char] -- appends first char of name
soundex1 lastname = [head lastname]

soundex2 :: LastName -> String
soundex2 name = head name : soundex2rec (rmvfirst name)

soundex2rec :: String -> String -- removes any h or w
soundex2rec [] = "" -- base case
soundex2rec name
    | head name == 'H' || head name == 'W' = soundex2rec (tail name)
    | otherwise = head name : soundex2rec (tail name)


soundex3 :: LastName -> String -- duplicates, just check for adjacent duplication
soundex3 [last] = [last] -- base case when we reach the end
soundex3 (first:next:rest) 
    | first == next = soundex3 (first : rest) -- if first char is same as the next one then remove the next char and check the first char with the rest
    | otherwise = first : soundex3 (next : rest) -- else its adjacent arent the same and just check the next char with the rest

soundex4 :: LastName -> String
soundex4 name = head name : soundex4rec (rmvfirst name)

soundex4rec :: String -> String -- removes all vowels and Y
soundex4rec [] = ""
soundex4rec name
    | head name == 'A' || head name == 'E' || head name == 'I' ||  head name == 'O' ||  head name == 'U' ||  head name == 'Y'= soundex4rec (tail name) -- if the char is a vowel, then remove it and check the rest
    | otherwise = head name : soundex4rec (tail name) -- else it isnt a vowel and keep it and check the rest

soundex5 :: LastName -> String
soundex5 name = rmvfirst(soundexpad (head name : soundex5rec (rmvfirst name)))

soundex5rec :: String -> String -- convert to numerical digits
soundex5rec [] = ""
soundex5rec (letter:rest)
    | letter == 'B' || letter == 'F' || letter == 'P' || letter == 'V' = '1' : soundex5rec rest
    | letter == 'C' || letter == 'G' || letter == 'J' || letter == 'K' || letter == 'Q' || letter == 'S' || letter == 'X' || letter == 'Z' = '2' : soundex5rec rest
    | letter == 'D' || letter == 'T'  = '3' : soundex5rec rest
    | letter == 'L' = '4' : soundex5rec rest
    | letter == 'M' || letter == 'N'  = '5' : soundex5rec rest
    | letter == 'R' = '6' : soundex5rec rest
    | otherwise = ""

soundexpad :: String -> String -- adjust soundexcode if its not exactly 4 chars
soundexpad soundexcheck
    | length soundexcheck < 4 = soundexfill (soundexcheck)
    | length soundexcheck > 4 = soundexrmv (soundexcheck)
    | otherwise = soundexcheck

soundexfill :: String -> String -- fills up code with "0"
soundexfill (letter:num1:num2:num3:[]) = letter:num1:num2:num3:[] -- basecase 
soundexfill soundexcode = soundexfill (soundexcode ++ "0") -- keeps appending 0 to the end until it hits the basecase

soundexrmv :: String -> String -- removes codes extra chars
soundexrmv (letter:num1:num2:num3:[]) = letter:num1:num2:num3:[] -- basecase if its removed till its only 4 code
soundexrmv soundexcode = soundexrmv (init soundexcode) -- keeps removing the last number until it hits the basecase 


soundex :: LastName -> SoundexCode -- main soundex code function that calls all the transformations
soundex lastname = soundex1 lastname ++ soundex5 (soundex4 (soundex3 (soundex2 lastname)))

queryfunc :: [(LastName,PhoneNumber)] -> LastName -> [PhoneNumber] -- querys the db for phonenumbers of same soundex code
queryfunc db lastname = [ pnum | (last,pnum) <- db, soundex last == soundex lastname]
