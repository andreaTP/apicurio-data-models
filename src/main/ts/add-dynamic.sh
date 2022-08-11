#! /bin/bash

# TODO: this works only on Mac and is a really bad hack to fix:
# https://github.com/angular/angular/issues/18867#issuecomment-357484102
# also ... depending on line numbers is a stupid idea, but it's enough to compile `apicurio-studio`

gsed -i '8 a // @dynamic' src/io/apicurio/datamodels/core/util/ReferenceResolverChain.ts
gsed -i '16 a // @dynamic' src/io/apicurio/datamodels/core/validation/rules/invalid/type/OasInvalidPropertyTypeValidationRule.ts
gsed -i '12 a // @dynamic' src/io/apicurio/datamodels/core/validation/rules/other/OasIgnoredHeaderParameterRule.ts
gsed -i '189 a // @dynamic' src/io/apicurio/datamodels/core/validation/ValidationRuleSet.ts
gsed -i '23 a // @dynamic' src/io/apicurio/datamodels/core/factories/VisitorFactory.ts
gsed -i '47 a // @dynamic' src/io/apicurio/datamodels/cloning/Aai20ModelClonerVisitor.ts
gsed -i '11 a // @dynamic' src/io/apicurio/datamodels/cmd/models/SimplifiedType.ts
gsed -i '17 a // @dynamic' src/io/apicurio/datamodels/cmd/commands/DeleteAllOperationsCommand.ts
gsed -i '18 a // @dynamic' src/io/apicurio/datamodels/cmd/commands/DeleteAllOperationsCommand_Aai20.ts
