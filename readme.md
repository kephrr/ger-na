ENDPOINTS

GET /services
GET /services/paginate?page=0&size=5
POST /services

GET /regions
GET /regions/paginate?page=0&size=5
POST /regions

GET /zones?region=0
GET /zones/paginate?page=0&size=5
POST /zones

GET /signalements?service=0&region=0&zone=0
GET /signalements/paginate?page=0&size=5&service=0&region=0&zone=0
GET /signalements/{id}
POST /signalements
