/*
 * Copyright 2020 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apicurio.datamodels.cmd.commands;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.asyncapi.models.AaiMessageTraitDefinition;
import io.apicurio.datamodels.asyncapi.v2.models.Aai20Document;
import io.apicurio.datamodels.asyncapi.v2.models.Aai20NodeFactory;
import io.apicurio.datamodels.cmd.AbstractCommand;
import io.apicurio.datamodels.cmd.util.ModelUtils;
import io.apicurio.datamodels.compat.LoggerCompat;
import io.apicurio.datamodels.compat.MarshallCompat;
import io.apicurio.datamodels.core.models.Document;

/**
 * A command used to remove a message trait definition item in an AsyncAPI document.
 * @author laurent.broudoux@gmail.com
 */
public class DeleteMessageTraitDefinitionCommand extends AbstractCommand {

   public String _name;

   @JsonDeserialize(using= MarshallCompat.NullableJsonNodeDeserializer.class)
   public Object _oldDefinition;
   public Integer _oldDefinitionIndex; // nullable for backwards compatibility

   public DeleteMessageTraitDefinitionCommand() {
   }

   public DeleteMessageTraitDefinitionCommand(String name) {
      this._name = name;
   }

   @Override
   public void execute(Document document) {
      LoggerCompat.info("[DeleteMessageTraitDefinitionCommand] Executing.");

      Aai20Document doc20 = (Aai20Document) document;
      if (ModelUtils.isDefined(doc20.components)) {
         AaiMessageTraitDefinition traitDef = doc20.components.getMessageTraitDefinition(_name);
         this._oldDefinitionIndex = doc20.components.getMessageTraitDefinitionsList().indexOf(traitDef);
         doc20.components.removeMessageTraitDefinition(_name);
         this._oldDefinition = Library.writeNode(traitDef);
      }
   }

   @Override
   public void undo(Document document) {
      LoggerCompat.info("[DeleteMessageTraitDefinitionCommand] Reverting.");
      if (this.isNullOrUndefined(this._oldDefinition)) {
         return;
      }

      Aai20Document doc20 = (Aai20Document) document;
      if (ModelUtils.isDefined(doc20.components)) {
         Aai20NodeFactory factory = new Aai20NodeFactory();
         AaiMessageTraitDefinition traitDef = factory.createMessageTraitDefinition(doc20.components, _name);
         Library.readNode(_oldDefinition, traitDef);
         doc20.components.restoreMessageTraitDefinition(_oldDefinitionIndex, _name, traitDef);
      }
   }
}
