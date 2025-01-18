var static_url = "https://81ff-94-131-12-15.ngrok-free.app"

function fetch_hotels_by_city(city){
    $http.query(static_url, {
    method: "GET",
    body: { "city": city },
    headers: {
        "Content-Type": "application/json"
    },
    dataType: "json",
    timeout: 10000
    });
}
    