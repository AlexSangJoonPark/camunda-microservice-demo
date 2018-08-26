#!/bin/bash
START=1
END=$1
INTERVAL=$2
for (( i=$START; i<=$END; i++ ))
do
    ORDER_ID="$i:order-$RANDOM"
    AMOUNT=$RANDOM
    curl -d "amount=$AMOUNT&orderId=$ORDER_ID" -X POST http://localhost:8080/order
    echo "orderId=$ORDER_ID amount=$AMOUNT sent!"
    sleep $INTERVAL
done
echo "Completed!"
