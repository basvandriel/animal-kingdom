SELECT
animal.`UUID`,
humanAnimalProperties.`partner_UUID`,
partnerHumanAnimalProperties.`partner_UUID` AS partner_partner_UUID

FROM `animal` AS animal

INNER JOIN `animal-properties` AS animalProperties
	ON animal.`animal-properties-id` = animalProperties.`id`

INNER JOIN `human-animal-properties` AS humanAnimalProperties
	ON animalProperties.`id` = humanAnimalProperties.`animal-properties-id`

INNER JOIN `animal` as partnerAnimal
	ON humanAnimalProperties.`partner_UUID` = partnerAnimal.`UUID`

INNER JOIN `animal-properties` AS partnerAnimalProperties
	ON partnerAnimal.`animal-properties-id` = partnerAnimalProperties.`id`

INNER JOIN `human-animal-properties` AS partnerHumanAnimalProperties
	ON partnerAnimalProperties.`id`  = partnerHumanAnimalProperties.`animal-properties-id`