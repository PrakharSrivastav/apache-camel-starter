# Simple app as an apache camel starter
This app shows how to setup a simple camel application with routes and processors. Examples for file and timer based integrations are available. The same application structure can be extended for more complex integrations.

## Basics

- Routing rules : A routing rule directs a message from sourcet to target with intermediate processing. a typical syntax for the routing rule is as follows:
```from("SourceURL").process().to("TergetURL")```

**Consumers and Producers**
A local route starts with a consumer (**from("SourceURL")**) and typically ends with producer (**to("TargetURL")**)

**Exchange message**
The exchange object consists of the message that is propagated through the route. The main constituents of the exchange message are as follows:

- In Message: The current message being processed by Camel. It consists of following components
	- Body
	- Headers
	- Attachments

- Out Message: 
	- Certain process nodes can treat In message as request and process/transform them. 
	- This transformed message is then set as the Out message. 
	- The old In message is discarded and the Out message is moved to the In message slot.

- Message Exchange Patterns (MEP) effects the interaction between the exchanges and the endpoints.
	- Consumer Endpoint sets the initial value of the MEP. The initial value determines if the consumer enpoint expects a reply (InOut MEP) or not (InOnly MEP).
	- Producer Endpoint . The MEP affects the producer endpoints. For eg , if the current MEP is InOnly, then producer does not expect to recieve a reply from the endpoint.

- Exchange properties a list of named properties containing metadata for the current message.


**Message Exchange Patterns**
- InOnly
- RobustInOnly
- InOut
- InOptinalOut
- OutOnly
- RobustOutOnly
- OutIn
- OutOptionalIn

### Directory Structure
- Application.java : Bootstrap application , add routes and lifecycle events. Services like tracing and logging drivers can be injected here
- processors/ : Package to hold all message processors.
- routes: Package to hold route builders
- models: Package to hold any models/domain objects