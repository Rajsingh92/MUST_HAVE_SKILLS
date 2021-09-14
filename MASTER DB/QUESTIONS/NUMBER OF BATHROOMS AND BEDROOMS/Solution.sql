SELECT 
    city,
    property_type,avg(bathrooms) n_bathrooms_avg,
    avg(bedrooms) n_bedrooms_avg
FROM airbnb_search_details
GROUP BY 
    city,
    property_type;

