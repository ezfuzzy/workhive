# workhive
[API -> DB -> Cafe Post] Auto publishing system

## 1. API & Crawling
- Get data from website (by scheduler)
- KONEPS(g2b) : API
- Albamon & Albacheonguk : Crawling (jsoup)

## 2. Organize Data and Insert to DB
DB - postgresql
table 
- KONEPS -> BiddingNotice
- Albamon & Albacheonguk -> Job

## 3. Publising
Naver Cafe - selenium
auto publishing 

## 4. Analyzing
use py for ai
