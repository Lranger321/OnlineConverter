# OnlineConverter API:

## Get exchange rate

```http
POST /exchange
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `from` | `string` | What currency from |
| `value` | `double` | Amount |
| `to` | `string` | What currency to |
| `user_id` | `int` | id for statistic |

### Response:

```
{
    "id" : int,
    "value" : double
}
```
## Get statistic
```http
GET /stat
```

### Response:

```
{
    "summary_stat" : [long],
    "stat": [long]
}
```
`summary_stat` - users who requested a conversion of more than $ 10,000 per request.

`stat` - users whose total requested volume is more than $ 10,000.

## Status Codes

| Status Code | Description |
| :--- | :--- |
| 200 | `OK` |
| 404 | `NOT FOUND` |
| 500 | `INTERNAL SERVER ERROR` |

## Run

```
mvn clean

mvn compile

mvn exec:java -Dexec.mainClass="Main" 

```
