var static_url = "https://30b0-94-131-12-15.ngrok-free.app"
function fetch_hotels_by_city(city){
    var response = $http.query(static_url+"/search_hotels", {
        method: "GET",
        body: { "city": city },
        headers: {
            "Content-Type": "application/json"
        },
        dataType: "json"
        });
    
    log(toPrettyString(response.data.hotels));
    return response.data.hotels;
}
    