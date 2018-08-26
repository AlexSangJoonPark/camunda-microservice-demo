# post_loc.txt contains the json you want to post
# -p means to POST it
# -H adds an Auth header (could be Basic or Token)
# -T sets the Content-Type
# -c is concurrent clients
# -n is the number of requests to run in the test

ab -p data.txt -T application/x-www-form-urlencoded -c $1 -n $2 http://localhost:8080/order
