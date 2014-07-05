WikiOntology
============

A framework for building ontologies from wiki articles. The library allows you to define attributes (like "color") 
and relations (like "has a" or "is in category"). An analysis is used to extract these informations from an article.


Entity
=======

An entity is built for each article. The entity contains the article identifier as well as attributes and relations.

Attributes
==========

To define an attribute you need to implement the Attribute\<T> interface, where T is type of the attribute.

Implemented attributes:
* Templates - a list of wikipedia templates.

Relations
=========

To define a relation you should extend the AbstractRelation class. Each relation contains a target, which is an Identifier.

Implemented relations:
* HasA
* IsA
* IsInCategory
* LinksTo

Predicates
==========

A predicate is a function that returns a boolean. Predicates are used to filter the articles during importing.

Analysis
========

An analysis is a function that processes the article to define attributes and create relations. To define an analysis you need to implement the Analysis interface. An analysis can depend on other using EntityBuilder's "requireAnalysis" method. EntityBuilder is smart enough to not run the same analysis twice.

Implemented analyses:
* CategoryExtractor - creates IsInCategory relations
* LinkExtractor - creates LinksTo relations
* PersonClassifier - creates IsA Person relations
* PersondataFinder - creates HasA Persondata relations
* PhysicistClassifier - creates IsA Physicist relations
* TemplateExtractor - extracts templates from an article and binds them to the "Templates" attribute

Importers
=========

Importers can be used to load articles and feed them to article consumers. Currently there is only one importer - XMLImporter - it loads wikipedia xml files.

OntologyBuilder
===============

OntologyBuilder is an article consumer that builds entities. You can specify which analysis should be run using the addAnalysis/removeAnalysis methods. Additionally you can filter out articles by specifying predicates using the addFilter/removeFilter methods.

Graph
=====

The graph module exports basic graph building and search. It uses an EdgeExtractor to discover edges between entities. So far Graph exports only the shortestPath method.
