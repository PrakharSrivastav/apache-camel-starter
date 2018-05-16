# Simple app as an apache camel starter
This app shows how to setup a simple camel application with routes and processors. Examples for file and timer based integrations are available. The same application structure can be extended for more complex integrations.


### Directory Structure
- Application.java : Bootstrap application , add routes and lifecycle events. Services like tracing and logging drivers can be injected here
- processors/ : Package to hold all message processors.
- routes: Package to hold route builders
- models: Package to hold any models/domain objects