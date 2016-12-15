SELECT
	std.name`animal`

    FROM `humanstds` AS humanstds

    INNER JOIN `std` AS std
    	ON humanstds.`std-id` = std.`id`

        WHERE humanstds.`human-animal-property-id` = ?;