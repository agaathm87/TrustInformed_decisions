package asl
 import _root_.scala.collection.mutable.HashMap

 import _root_.akka.actor.typed.{ActorRef, Behavior, SupervisorStrategy}
 import _root_.akka.actor.typed.scaladsl.{ActorContext, Behaviors, Routers}
 import java.util.logging.Logger
 import _root_.scala.util.Failure
 import _root_.scala.util.Success
 import _root_.akka.util.Timeout
 import _root_.scala.concurrent.duration._
 import _root_.akka.actor.typed.scaladsl.AskPattern._
 import _root_.scala.language.implicitConversions
 import _root_.scala.concurrent.{Await, Future}
 import _root_.scala.jdk.CollectionConverters._
 import std.converters._

 import scala.util.Random
 import bb._
 import infrastructure._
 import bb.expstyla.exp._
 import std.{AgentCommunicationLayer, DefaultCommunications}

 class competence  (coms: AgentCommunicationLayer = new  DefaultCommunications,
                                     beliefBaseFactory: IBeliefBaseFactory = new StylaBeliefBaseFactory)
                      extends IntentionalAgentFactory {


 object Intention {

       def apply(p_executionContext: ExecutionContext): Behavior[ISubGoalMessage] = Behaviors.setup { context =>

         Behaviors.receive {
         (context, message) =>

          implicit val executionContext = p_executionContext.copy(intention = context, src = message.source)

         message match {
            case SubGoalMessage(_,_,r) =>
               message.goal match {

                   case competence.this.adopt_achievement_getnames_0 =>
                     competence.this.adopt_achievement_getnames_0.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_update_competence_1 =>
                     competence.this.adopt_achievement_update_competence_1.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_handle_pending_action_2 =>
                     competence.this.adopt_achievement_handle_pending_action_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_handle_subplans_2 =>
                     competence.this.adopt_achievement_handle_subplans_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_check_and_assign_defaults_2 =>
                     competence.this.adopt_achievement_check_and_assign_defaults_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_check_and_assign_defaults_resource_3 =>
                     competence.this.adopt_achievement_check_and_assign_defaults_resource_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_check_and_assign_defaults_skill_3 =>
                     competence.this.adopt_achievement_check_and_assign_defaults_skill_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_check_and_assign_defaults_knowledge_3 =>
                     competence.this.adopt_achievement_check_and_assign_defaults_knowledge_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_add_info_3 =>
                     competence.this.adopt_achievement_add_info_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_init_counters_1 =>
                     competence.this.adopt_achievement_init_counters_1.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_competent_2 =>
                     competence.this.adopt_achievement_competent_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_comp_conditions_3 =>
                     competence.this.adopt_achievement_comp_conditions_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_comp_subplans_2 =>
                     competence.this.adopt_achievement_comp_subplans_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_comp_total_2 =>
                     competence.this.adopt_achievement_comp_total_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_competence_calc_2 =>
                     competence.this.adopt_achievement_competence_calc_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_incompetence_calc_2 =>
                     competence.this.adopt_achievement_incompetence_calc_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_incompetence_score_only_2 =>
                     competence.this.adopt_achievement_incompetence_score_only_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_competence_score_only_2 =>
                     competence.this.adopt_achievement_competence_score_only_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_comp_conditions_score_only_succes_3 =>
                     competence.this.adopt_achievement_comp_conditions_score_only_succes_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_comp_conditions_score_only_failure_3 =>
                     competence.this.adopt_achievement_comp_conditions_score_only_failure_3.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_update_competence_succes_2 =>
                     competence.this.adopt_achievement_update_competence_succes_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_update_competence_failures_2 =>
                     competence.this.adopt_achievement_update_competence_failures_2.execute(message.params.asInstanceOf[Parameters])

                   case competence.this.adopt_achievement_update_competence_failure_3 =>
                     competence.this.adopt_achievement_update_competence_failure_3.execute(message.params.asInstanceOf[Parameters])


           case _ =>
             context.log.error("This actor can not handle goal of type {}", message.goal)
         }
           r match {
                 case a : AkkaMessageSource => 
                   a.src ! IntentionDoneMessage(AkkaMessageSource(executionContext.agent.self))
                 case DummyMessageSource(_) => 
                   context.log.error("Intention Done!")
               }

               Behaviors.same
             case InitEndMessage(r) =>
               Behaviors.stopped
       }
      }
     }
     }

 override def agentBuilder: Agent = new Agent()
 class Agent extends IAgent {

         override def agent_type: String = "competence"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("getnames",Seq[GenericTerm](  ))


         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("agent",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]())))
           ,
            StructTerm("trustor",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("succes",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("failure",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("subplan",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]())))
           ,
            StructTerm("subplan",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]())))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("knowledge",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("resource",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("skill",Seq[GenericTerm](StructTerm("damiann",Seq[GenericTerm]()),StructTerm("dusting",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("resource",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("skill",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("weeding",Seq[GenericTerm]()),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("herbology",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("weeding",Seq[GenericTerm]()),StructTerm("resource",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("weeding",Seq[GenericTerm]()),StructTerm("skill",Seq[GenericTerm]()),StructTerm("ability",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("resource",Seq[GenericTerm]()),StructTerm("vacuum",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("skill",Seq[GenericTerm]()),StructTerm("thoroughness",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("dusting",Seq[GenericTerm]()),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("surfaces",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("dusting",Seq[GenericTerm]()),StructTerm("resource",Seq[GenericTerm]()),StructTerm("duster",Seq[GenericTerm]())))
           ,
            StructTerm("prerequisits",Seq[GenericTerm](StructTerm("dusting",Seq[GenericTerm]()),StructTerm("skill",Seq[GenericTerm]()),StructTerm("attention",Seq[GenericTerm]())))
           ,
            StructTerm("threshold_knowledge",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("threshold_skill",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("threshold_resource",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("threshold_knowledge",Seq[GenericTerm](StructTerm("weeding",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("threshold_skill",Seq[GenericTerm](StructTerm("weeding",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("threshold_resource",Seq[GenericTerm](StructTerm("weeding",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("threshold_knowledge",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("threshold_skill",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("threshold_resource",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("threshold_knowledge",Seq[GenericTerm](StructTerm("dusting",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("threshold_skill",Seq[GenericTerm](StructTerm("dusting",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("threshold_resource",Seq[GenericTerm](StructTerm("dusting",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("relationship",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("friend",Seq[GenericTerm]())))
           ,
            StructTerm("relationship",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("paula",Seq[GenericTerm]()),StructTerm("collegue",Seq[GenericTerm]())))
           ,
            StructTerm("relationship",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("damian",Seq[GenericTerm]()),StructTerm("acquaintance",Seq[GenericTerm]())))
           ,
            StructTerm("relationship_strength",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("relationship_strength",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("paula",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("relationship_strength",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("damian",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("friend",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("acquaintance",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("neighbour",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("collegue",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("weight_resource",Seq[GenericTerm](DoubleTerm(0.3)))
           ,
            StructTerm("weight_skill",Seq[GenericTerm](DoubleTerm(0.4)))
           ,
            StructTerm("weight_knowledge",Seq[GenericTerm](DoubleTerm(0.3)))
           ,
            StructTerm("number_of_subs",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("succeeded_subs",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("competence_sub",Seq[GenericTerm](vars("_"),vars("_"),IntTerm(0)))
           ,
            StructTerm("competence_provider_agent",Seq[GenericTerm](StringTerm("competence")))
           ,
            StructTerm("benevolence_provider_agent",Seq[GenericTerm](StringTerm("benevolence")))
           ,
            StructTerm("integrity_provider_agent",Seq[GenericTerm](StringTerm("integrity")))
           ,
            StructTerm("decision_maker_agent",Seq[GenericTerm](StringTerm("decisionCosinesim")))
           ,
            StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](StringTerm("trustworthiness")))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"))))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),IntTerm(0)))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"))))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),IntTerm(0)))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"))))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),IntTerm(0)))))))


         )

         def planApplicabilities()(implicit executionContext: ExecutionContext) = List[StructTerm](

                 )



      def apply(name: String, yellowPages: IYellowPages, MAS: ActorRef[IMessage], parent: IMessageSource): Behavior[IMessage] = {
           Behaviors.setup { context =>
             val yp: IYellowPages = yellowPages
             val bb: IBeliefBase[GenericTerm] = beliefBaseFactory()
             implicit val executionContext: ExecutionContext = ExecutionContext(
                            name = name,
                            agentType = agent_type,
                            agent = context,
                            yellowPages = yp,
                            beliefBase = bb,
                            logger = context.log,
                            goalParser = GoalParser,
                            parent = parent
                          )
             bb.assert(initBeliefs)
             bb.assert(planApplicabilities)

         val initiator = context.spawn(Intention(executionContext), "initiator")

         MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case StartMessage() =>


                 implicit val timeout: Timeout = 99999.seconds
                 implicit val ec = context.executionContext
                 implicit val scheduler = context.system.scheduler


                 //              initGoals.foreach( tuple => initiator ! SubGoalMessage(tuple._1,tuple._2,context.self))
                 initGoals.foreach(struct => {


                   val result: Future[IMessage] = initiator.ask[IMessage](ref => {
                     val subGoal = GoalParser.create_goal_message(struct, AkkaMessageSource(ref))
                     if (subGoal.isDefined)
                       subGoal.get
                     else
                       throw new RuntimeException(s"No plan for initial goal $struct")
                     }
                   )


                   //result.onComplete {
                   //  case Success(IntentionDoneMessage(r)) => IntentionDoneMessage(r)
                   //  case Failure(_) => IntentionErrorMessage(src = null)
                   //}

                   //Await.result(result, timeout.duration)

                   val res = Await.result(result, timeout.duration)

                   if(!res.isInstanceOf[IntentionDoneMessage]) {
                     throw new RuntimeException(s"Issue with initial goal $struct")
                     context.system.terminate()
                   }

                   //                context.ask[ISubGoalMessage, IMessage](initiator, ref => SubGoalMessage(tuple._1, tuple._2,name, ref)) {
                   //                  case Success(IntentionDoneMessage(_, _)) => IntentionDoneMessage()
                   //                  case Failure(_) => IntentionErrorMessage()
                   //                }
                 }
                 )

                 initiator ! InitEndMessage(context.self)
                 normal_behavior(MAS)

               //            case InitEndMessage(_) =>
               //              context.log.debug(f"$name: I have started, switching behavior")
               //              normal_behavior()
             }

         }
       }
     }

     def normal_behavior(MAS: ActorRef[IMessage])(implicit executionContext: ExecutionContext): Behavior[IMessage] = {
       Behaviors.setup { context =>

         val pool = Routers.pool(poolSize = 8)(
           Behaviors.supervise(Intention(executionContext)).onFailure[Exception](SupervisorStrategy.restart))

         val router = context.spawn(pool, "intention-pool")
         //MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case IntentionDoneMessage(s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s")
               case IntentionErrorMessage(c,s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s: $c")
               case SubGoalMessage(_, _, _) =>
                 router ! message.asInstanceOf[SubGoalMessage]
               case GoalMessage(m, ref) =>
                 m match {
                   case t: StructTerm =>
                     val subGoal = GoalParser.create_goal_message(t, ref)

                     if (subGoal.isDefined)
                       context.self ! subGoal.get
                     else
                       ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))


                 }

                case AskMessage(m, ref) =>
                                m match {
                                  case t: StructTerm =>
                                    val subGoal = GoalParser.create_test_message(t, ref)

                                    if (subGoal.isDefined)
                                      context.self ! subGoal.get
                                    else
                                      ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))
                                }
             case BeliefMessage(m, ref) =>
                  m match {
                    case t: StructTerm =>
                    if(executionContext.beliefBase.assertOne(t)) {
                      val subGoal = GoalParser.create_belief_message(t, ref)

                      if (subGoal.isDefined)
                        context.self ! subGoal.get
                    }
                  }

              case UnBeliefMessage(m, ref) =>
                   m match {
                     case t: StructTerm =>
                     if(executionContext.beliefBase.retractOne(t)) {
                       val subGoal = GoalParser.create_unbelief_message(t, ref)

                       if (subGoal.isDefined)
                         context.self ! subGoal.get
                     }
                   }
             }
             Behaviors.same
         }
       }
     }
   }



   object GoalParser extends IAgentGoalParser {
        override def create_goal_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                   if(t.matchOnlyFunctorAndArity("getnames",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_getnames_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("handle_pending_action",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_handle_pending_action_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("handle_subplans",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_handle_subplans_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("check_and_assign_defaults",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_check_and_assign_defaults_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("check_and_assign_defaults_resource",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_check_and_assign_defaults_resource_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("check_and_assign_defaults_skill",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_check_and_assign_defaults_skill_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("check_and_assign_defaults_knowledge",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_check_and_assign_defaults_knowledge_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("add_info",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_add_info_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("init_counters",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_init_counters_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("competent",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_competent_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_conditions",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_conditions_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_subplans",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_subplans_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_total",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_total_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("competence_calc",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_competence_calc_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("incompetence_calc",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_incompetence_calc_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("incompetence_score_only",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_incompetence_score_only_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("competence_score_only",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_competence_score_only_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_conditions_score_only_succes",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_conditions_score_only_succes_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_conditions_score_only_failure",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_conditions_score_only_failure_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence_succes",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_succes_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence_failures",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_failures_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence_failure",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_failure_3, args, ref))
                                   } else   {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                          {
                    Option.empty[SubGoalMessage]
                    }

                }

         override def create_test_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                                  {
                            Option.empty[SubGoalMessage]
                            }
                        }
          override def create_unbelief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                                           {
                                     Option.empty[SubGoalMessage]
                                     }
                                 }



        }


      object adopt_achievement_getnames_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L54037 = executionContext.beliefBase.bufferedQuery( StructTerm("agent",Seq[GenericTerm](vars("L54037"))) )
                                               while (ex_L54037.hasNext) {
                                                   val sol_L54037 = ex_L54037.next
                                                   if(sol_L54037.result) {
                                                   vars += ("A" -> sol_L54037.bindings("L54037").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_update_competence_1.execute(Parameters(List( vars("A")  )))

                                                   }
                                               }
                                           vars -= ("A")


                     }


      }

      object adopt_achievement_update_competence_1 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("------Updating competence of agent ") + vars("A"))  + StringTerm("------")) )))
                                               val ex_L91809 = executionContext.beliefBase.bufferedQuery( StructTerm("succes",Seq[GenericTerm](vars("A"),vars("L91809"))) )
                                               while (ex_L91809.hasNext) {
                                                   val sol_L91809 = ex_L91809.next
                                                   if(sol_L91809.result) {
                                                   vars += ("Action" -> sol_L91809.bindings("L91809").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("Action"))))
                                                                       adopt_achievement_check_and_assign_defaults_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                       adopt_achievement_handle_subplans_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("Action ") + vars("Action"))  + StringTerm(" is in success.")) )))
                                                                       adopt_achievement_competence_score_only_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                       adopt_achievement_update_competence_succes_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                                   }
                                               }
                                           vars -= ("Action")
                                               val ex_L30967 = executionContext.beliefBase.bufferedQuery( StructTerm("failure",Seq[GenericTerm](vars("A"),vars("L30967"),vars("_"))) )
                                               while (ex_L30967.hasNext) {
                                                   val sol_L30967 = ex_L30967.next
                                                   if(sol_L30967.result) {
                                                   vars += ("Action" -> sol_L30967.bindings("L30967").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("Action"))))
                                                                       adopt_achievement_check_and_assign_defaults_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                       adopt_achievement_handle_subplans_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("Action ") + vars("Action"))  + StringTerm(" is in failure.")) )))
                                                                       adopt_achievement_incompetence_score_only_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                       adopt_achievement_update_competence_failures_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                                   }
                                               }
                                           vars -= ("Action")
                                               val ex_L31236 = executionContext.beliefBase.bufferedQuery( StructTerm("goal",Seq[GenericTerm](vars("A"),vars("L31236"))) )
                                               while (ex_L31236.hasNext) {
                                                   val sol_L31236 = ex_L31236.next
                                                   if(sol_L31236.result) {
                                                   vars += ("Action" -> sol_L31236.bindings("L31236").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_handle_pending_action_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                                   }
                                               }
                                           vars -= ("Action")


                     }


      }

      object adopt_achievement_handle_pending_action_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("succes",Seq[GenericTerm](vars("A"),vars("Action"))))),StructTerm("not",Seq[GenericTerm](StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Action"),vars("_"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("Action ") + vars("Action"))  + StringTerm(" is neither in success nor failure.")) )))
                                          adopt_achievement_check_and_assign_defaults_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                          adopt_achievement_handle_subplans_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                          adopt_achievement_competent_2.execute(Parameters(List( vars("A") , vars("Action")  )))


                     }


      }

      object adopt_achievement_handle_subplans_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Handling subplans for ") + vars("Action")) )))
                                               val ex_L61417 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L61417"))) )
                                               while (ex_L61417.hasNext) {
                                                   val sol_L61417 = ex_L61417.next
                                                   if(sol_L61417.result) {
                                                   vars += ("Subaction" -> sol_L61417.bindings("L61417").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Subplan: ") + vars("Subaction")) )))
                                                                       adopt_achievement_check_and_assign_defaults_2.execute(Parameters(List( vars("A") , vars("Subaction")  )))

                                                   }
                                               }
                                           vars -= ("Subaction")


                     }


      }

      object adopt_achievement_check_and_assign_defaults_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L71425 = executionContext.beliefBase.bufferedQuery( StructTerm("prerequisits",Seq[GenericTerm](StringTerm("knowledge"),vars("Action"),vars("L71425"))) )
                                               while (ex_L71425.hasNext) {
                                                   val sol_L71425 = ex_L71425.next
                                                   if(sol_L71425.result) {
                                                   vars += ("Condition" -> sol_L71425.bindings("L71425").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_check_and_assign_defaults_knowledge_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Condition")  )))

                                                   }
                                               }
                                           vars -= ("Condition")
                                               val ex_L84091 = executionContext.beliefBase.bufferedQuery( StructTerm("prerequisits",Seq[GenericTerm](StringTerm("resource"),vars("Action"),vars("L84091"))) )
                                               while (ex_L84091.hasNext) {
                                                   val sol_L84091 = ex_L84091.next
                                                   if(sol_L84091.result) {
                                                   vars += ("Condition" -> sol_L84091.bindings("L84091").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_check_and_assign_defaults_resource_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Condition")  )))

                                                   }
                                               }
                                           vars -= ("Condition")
                                               val ex_L78254 = executionContext.beliefBase.bufferedQuery( StructTerm("prerequisits",Seq[GenericTerm](StringTerm("skill"),vars("Action"),vars("L78254"))) )
                                               while (ex_L78254.hasNext) {
                                                   val sol_L78254 = ex_L78254.next
                                                   if(sol_L78254.result) {
                                                   vars += ("Condition" -> sol_L78254.bindings("L78254").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_check_and_assign_defaults_skill_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Condition")  )))

                                                   }
                                               }
                                           vars -= ("Condition")


                     }


      }

      object adopt_achievement_check_and_assign_defaults_resource_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("prerequisits",Seq[GenericTerm](StringTerm("resource"),vars("Action"),vars("Condition"))),StructTerm("missing_or_zero_resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))))),StructTerm("relationship",Seq[GenericTerm](vars("B"),vars("A"),vars("Reltype"))))),StructTerm("weight_relationship",Seq[GenericTerm](vars("Reltype"),vars("Weight"))))),StructTerm("relationship_strength",Seq[GenericTerm](vars("B"),vars("A"),vars("Strength"))))),StructTerm("is",Seq[GenericTerm](vars("DefaultScore"),StructTerm("*",Seq[GenericTerm](vars("Strength"),vars("Weight"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("prerequisits",Seq[GenericTerm](StringTerm("resource"),vars("Action"),vars("Condition"))),StructTerm("missing_or_zero_resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( (StringTerm("Assigned default score for resource ") + vars("Condition"))  + StringTerm(" in "))  + vars("Action"))  + StringTerm(" based on relationship: "))  + vars("Reltype"))  + StringTerm(" assigned "))  + vars("DefaultScore"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("DefaultScore")))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("No relationship found for resource ") + vars("Condition"))  + StringTerm(" in "))  + vars("Action"))  + StringTerm(". Assigning default value 0.5.")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),DoubleTerm(0.5)))),GoalParser)


                     }


      }

      object adopt_achievement_check_and_assign_defaults_skill_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("prerequisits",Seq[GenericTerm](StringTerm("skill"),vars("Action"),vars("Condition"))),StructTerm("missing_or_zero_skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))))),StructTerm("relationship",Seq[GenericTerm](vars("B"),vars("A"),vars("Reltype"))))),StructTerm("weight_relationship",Seq[GenericTerm](vars("Reltype"),vars("Weight"))))),StructTerm("relationship_strength",Seq[GenericTerm](vars("B"),vars("A"),vars("Strength"))))),StructTerm("is",Seq[GenericTerm](vars("DefaultScore"),StructTerm("*",Seq[GenericTerm](vars("Strength"),vars("Weight"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("prerequisits",Seq[GenericTerm](StringTerm("skill"),vars("Action"),vars("Condition"))),StructTerm("missing_or_zero_skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( (StringTerm("Assigned default score for skill ") + vars("Condition"))  + StringTerm(" in "))  + vars("Action"))  + StringTerm(" based on relationship: "))  + vars("Reltype"))  + StringTerm(" assigned "))  + vars("DefaultScore"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("DefaultScore")))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("No skill found for ") + vars("Condition"))  + StringTerm(". Assigning default skill 0.5.")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),DoubleTerm(0.5)))),GoalParser)


                     }


      }

      object adopt_achievement_check_and_assign_defaults_knowledge_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("prerequisits",Seq[GenericTerm](StringTerm("knowledge"),vars("Action"),vars("Condition"))),StructTerm("missing_or_zero_knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("prerequisits",Seq[GenericTerm](StringTerm("knowledge"),vars("Action"),vars("Condition"))),StructTerm("missing_or_zero_knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"))))),StructTerm("relationship",Seq[GenericTerm](vars("B"),vars("A"),vars("Reltype"))))),StructTerm("weight_relationship",Seq[GenericTerm](vars("Reltype"),vars("Weight"))))),StructTerm("relationship_strength",Seq[GenericTerm](vars("B"),vars("A"),vars("Strength"))))),StructTerm("is",Seq[GenericTerm](vars("DefaultScore"),StructTerm("*",Seq[GenericTerm](vars("Strength"),vars("Weight"))))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("No knowledge found for ") + vars("Condition"))  + StringTerm(". Assigning default knowledge 0.5.")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),DoubleTerm(0.5)))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( (StringTerm("Assigned default score for knowledge ") + vars("Condition"))  + StringTerm(" in "))  + vars("Action"))  + StringTerm(" based on relationship: "))  + vars("Reltype"))  + StringTerm(" assigned "))  + vars("DefaultScore"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("_"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("DefaultScore")))),GoalParser)


                     }


      }

      object adopt_achievement_add_info_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r2 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r3 = executionContext.beliefBase.query(StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r4 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end



                 //plan 5 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r5 = executionContext.beliefBase.query(StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))))

                         if (r5.result) {
                             r5.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan5(vars)
                             return
                          }

                          // plan 5 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("X"),vars("High"))))
                                          if(( ( (vars("X") > vars("Low"))  &&  (vars("X") <= vars("High")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)

                                          }


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("X"),IntTerm(1))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),IntTerm(1)))),GoalParser)


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("X"),vars("High"))))
                                          if(( ( (vars("X") > vars("Low"))  &&  (vars("X") <= vars("High")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)

                                          }


                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("X"),IntTerm(1))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),IntTerm(1)))),GoalParser)


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("X"),vars("High"))))
                                          if(( ( (vars("X") > vars("Low"))  &&  (vars("X") <= vars("High")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)

                                          }


                     }
                      def plan5(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("X"),IntTerm(1))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),DoubleTerm(0.1)))),GoalParser)


                     }


      }

      object adopt_achievement_init_counters_1 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Action" -> params.l_params(0))

                         val r0 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("_"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)


                     }


      }

      object adopt_achievement_competent_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_counters_1.execute(Parameters(List( vars("Action")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Evaluating the competence of ") + vars("A"))  + StringTerm(" for the goal: "))  + vars("Action")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("The goal ") + vars("Action"))  + StringTerm(" consists of the subplans: ")) )))
                                               val ex_L53938 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L53938"))) )
                                               while (ex_L53938.hasNext) {
                                                   val sol_L53938 = ex_L53938.next
                                                   if(sol_L53938.result) {
                                                   vars += ("Subaction" -> sol_L53938.bindings("L53938").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("- ") + vars("Subaction")) )))

                                                   }
                                               }
                                           vars -= ("Subaction")
                                               val ex_L72114 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L72114"))) )
                                               while (ex_L72114.hasNext) {
                                                   val sol_L72114 = ex_L72114.next
                                                   if(sol_L72114.result) {
                                                   vars += ("Subaction" -> sol_L72114.bindings("L72114").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm(" "))))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Evaluating the subplan: ") + vars("Subaction")) )))
                                                                       adopt_achievement_comp_conditions_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Subaction")  )))
                                                                       adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Subaction")  )))

                                                   }
                                               }
                                           vars -= ("Subaction")
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Evaluating the main goal: ") + vars("Action")) )))
                                          adopt_achievement_comp_conditions_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Action")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Before comp_total for ") + vars("Action")) )))
                                          adopt_achievement_comp_total_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("After comp_total for ") + vars("Action")) )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Evaluating the competence of ") + vars("A"))  + StringTerm(" for the goal: "))  + vars("Action")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("The goal ") + vars("Action"))  + StringTerm(" has no subplans.")) )))
                                          adopt_achievement_comp_conditions_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_total_2.execute(Parameters(List( vars("A") , vars("Action")  )))


                     }


      }

      object adopt_achievement_comp_conditions_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Subaction" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("weight_knowledge",Seq[GenericTerm](vars("WK"))),StructTerm("weight_skill",Seq[GenericTerm](vars("WS"))))),StructTerm("weight_resource",Seq[GenericTerm](vars("WR"))))),StructTerm("threshold_knowledge",Seq[GenericTerm](vars("Subaction"),vars("TK"))))),StructTerm("threshold_skill",Seq[GenericTerm](vars("Subaction"),vars("TS"))))),StructTerm("threshold_resource",Seq[GenericTerm](vars("Subaction"),vars("TR"))))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Knowledge"),vars("K"))))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Skill"),vars("S"))))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Resource"),vars("R"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("WeightedKnowledge" ->  (vars("K") * vars("WK")) )
                                           vars += ("WeightedSkill" ->  (vars("S") * vars("WS")) )
                                           vars += ("WeightedResource" ->  (vars("R") * vars("WR")) )
                                           vars += ("WTK" ->  (vars("TK") * vars("WK")) )
                                           vars += ("WTS" ->  (vars("TS") * vars("WS")) )
                                           vars += ("WTR" ->  (vars("TR") * vars("WR")) )
                                           vars += ("SubScore" ->  ( ( (vars("WeightedKnowledge") + vars("WeightedSkill"))  + vars("WeightedResource"))  /  ( (vars("WK") + vars("WS"))  + vars("WR")) ) )
                                          if(( ( ( (vars("WeightedKnowledge") >= vars("WTK"))  &&  (vars("WeightedSkill") >= vars("WTS")) )  &&  (vars("WeightedResource") >= vars("WTR")) ) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("- ") + vars("A"))  + StringTerm(" is competent for the subplan: "))  + vars("Subaction")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Competence score: ") + vars("SubScore")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),vars("_")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),IntTerm(1)))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competent",Seq[GenericTerm](vars("A"),vars("Subaction")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("SubScore")))),GoalParser)

                                          }
                                           else {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("- ") + vars("A"))  + StringTerm(" is incompetent for the subplan: "))  + vars("Subaction")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Competence score: ") + vars("SubScore")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),vars("_")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),IntTerm(0)))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("SubScore")))),GoalParser)

                                           }
                                          if(( (vars("WeightedKnowledge") < vars("WTK")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("-> ") + vars("A"))  + StringTerm(" misses "))  +  (vars("WTK") - vars("WeightedKnowledge")) )  + StringTerm(" knowledge")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Knowledge")))),GoalParser)

                                          }
                                          if(( (vars("WeightedSkill") < vars("WTS")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("-> ") + vars("A"))  + StringTerm(" misses "))  +  (vars("WTS") - vars("WeightedSkill")) )  + StringTerm(" skills")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Skill")))),GoalParser)

                                          }
                                          if(( (vars("WeightedResource") < vars("WTR")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("-> ") + vars("A"))  + StringTerm(" misses resources")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Resource")))),GoalParser)

                                          }


                     }


      }

      object adopt_achievement_comp_subplans_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Action" -> params.l_params(0))
                          vars +=(   "Subaction" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),vars("SubComp"))),StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS"))))),StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("SS"))))),StructTerm("is",Seq[GenericTerm](vars("NewNS"),StructTerm("+",Seq[GenericTerm](vars("NS"),IntTerm(1))))))),StructTerm("is",Seq[GenericTerm](vars("NewSS"),StructTerm("+",Seq[GenericTerm](vars("SS"),vars("SubComp"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("Counting subplan: ") + vars("Subaction"))  + StringTerm(" for "))  + vars("Action"))  + StringTerm(" (sub_comp="))  + vars("SubComp"))  + StringTerm(")")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("number_of_subs before: ") + vars("NS"))  + StringTerm(", succeeded_subs before: "))  + vars("SS")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NewNS")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("SS")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("NewSS")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("number_of_subs after: ") + vars("NewNS"))  + StringTerm(", succeeded_subs after: "))  + vars("NewSS")) )))


                     }


      }

      object adopt_achievement_comp_total_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS"))),StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("SS"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm(" "))))
                                          if(( (vars("NS") == vars("SS")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (vars("A") + StringTerm(" is competent for the goal: "))  + vars("Action")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succes",Seq[GenericTerm](vars("A"),vars("Action")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competent",Seq[GenericTerm](vars("A"),vars("Action")))),GoalParser)
                                                                  adopt_achievement_competence_calc_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                  adopt_achievement_update_competence_succes_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                          }
                                           else {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (vars("A") + StringTerm(" is incompetent for the goal: "))  + vars("Action")) )))
                                                                  adopt_achievement_incompetence_calc_2.execute(Parameters(List( vars("A") , vars("Action")  )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),IntTerm(0)))),GoalParser)
                                                                  adopt_achievement_update_competence_failures_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                           }


                     }


      }

      object adopt_achievement_competence_calc_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))),StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS"))))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))))),StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("ScoredItemName"),vars("SubScore"))))),StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS"))))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("TotalCompetenceScore" -> IntTerm(0))
                                           vars += ("OverallScore" -> IntTerm(0))
                                               val ex_L53705 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L53705"))) )
                                               while (ex_L53705.hasNext) {
                                                   val sol_L53705 = ex_L53705.next
                                                   if(sol_L53705.result) {
                                                   vars += ("Subaction" -> sol_L53705.bindings("L53705").asInstanceOf[GenericTerm])
                                                                            val ex_L44117 = executionContext.beliefBase.bufferedQuery( StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("L44117"))) )
                                                                            while (ex_L44117.hasNext) {
                                                                                val sol_L44117 = ex_L44117.next
                                                                                if(sol_L44117.result) {
                                                                                vars += ("SubScore" -> sol_L44117.bindings("L44117").asInstanceOf[GenericTerm])
                                                                                                     vars += ("TotalCompetenceScore" ->  (vars("TotalCompetenceScore") + vars("SubScore")) )

                                                                                }
                                                                            }
                                                                        vars -= ("SubScore")

                                                   }
                                               }
                                           vars -= ("Subaction")
                                               val ex_L45428 = executionContext.beliefBase.bufferedQuery( StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Action"),vars("L45428"))) )
                                               while (ex_L45428.hasNext) {
                                                   val sol_L45428 = ex_L45428.next
                                                   if(sol_L45428.result) {
                                                   vars += ("Mainscore" -> sol_L45428.bindings("L45428").asInstanceOf[GenericTerm])
                                                                        vars += ("TotalCompetenceScore" ->  (vars("TotalCompetenceScore") + vars("Mainscore")) )

                                                   }
                                               }
                                           vars -= ("Mainscore")
                                           vars += ("OverallScore" ->  (vars("TotalCompetenceScore") / vars("NS")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Competence score for ") + vars("A"))  + StringTerm(" on "))  + vars("Action"))  + StringTerm(": "))  + vars("OverallScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("Tagent"),StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore"))))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("OverallScore" -> vars("SubScore"))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Competence score for ") + vars("A"))  + StringTerm(" on "))  + vars("Action"))  + StringTerm(": "))  + vars("OverallScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("Tagent"),StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallScore"))))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)


                     }


      }

      object adopt_achievement_incompetence_calc_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))))),StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("ScoredItemName"),vars("SubScore"))))),StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS"))))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("Subaction"))),StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("NS"))))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("OverallincScore" -> IntTerm(0))
                                           vars += ("OverallincScore" ->  (IntTerm(1) - vars("SubScore")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Incompetence score for ") + vars("A"))  + StringTerm(" on "))  + vars("Action"))  + StringTerm(": "))  + vars("OverallincScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallincScore")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallincScore")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallincScore"))))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("TotalinCompetenceScore" -> IntTerm(0))
                                           vars += ("OverallincScore" -> IntTerm(0))
                                               val ex_L28651 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L28651"))) )
                                               while (ex_L28651.hasNext) {
                                                   val sol_L28651 = ex_L28651.next
                                                   if(sol_L28651.result) {
                                                   vars += ("Subaction" -> sol_L28651.bindings("L28651").asInstanceOf[GenericTerm])
                                                                            val ex_L1360 = executionContext.beliefBase.bufferedQuery( StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("L1360"))) )
                                                                            while (ex_L1360.hasNext) {
                                                                                val sol_L1360 = ex_L1360.next
                                                                                if(sol_L1360.result) {
                                                                                vars += ("SubScore" -> sol_L1360.bindings("L1360").asInstanceOf[GenericTerm])
                                                                                                     vars += ("TotalinCompetenceScore" ->  (vars("TotalinCompetenceScore") + vars("SubScore")) )

                                                                                }
                                                                            }
                                                                        vars -= ("SubScore")

                                                   }
                                               }
                                           vars -= ("Subaction")
                                               val ex_L44152 = executionContext.beliefBase.bufferedQuery( StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Action"),vars("L44152"))) )
                                               while (ex_L44152.hasNext) {
                                                   val sol_L44152 = ex_L44152.next
                                                   if(sol_L44152.result) {
                                                   vars += ("Mainscore" -> sol_L44152.bindings("L44152").asInstanceOf[GenericTerm])
                                                                        vars += ("TotalinCompetenceScore" ->  (vars("TotalinCompetenceScore") + vars("Mainscore")) )

                                                   }
                                               }
                                           vars -= ("Mainscore")
                                           vars += ("OverallincScore" ->  (IntTerm(1) -  (vars("TotalinCompetenceScore") / vars("NS")) ) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Incompetence score for ") + vars("A"))  + StringTerm(" on "))  + vars("Action"))  + StringTerm(": "))  + vars("OverallincScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallincScore")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallincScore")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Action"),vars("OverallincScore"))))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("succeeded_subs",Seq[GenericTerm](vars("Action"),IntTerm(0)))),GoalParser)


                     }


      }

      object adopt_achievement_incompetence_score_only_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("_"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("_"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_counters_1.execute(Parameters(List( vars("Action")  )))
                                          adopt_achievement_comp_conditions_score_only_failure_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Action")  )))
                                          adopt_achievement_incompetence_calc_2.execute(Parameters(List( vars("A") , vars("Action")  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_counters_1.execute(Parameters(List( vars("Action")  )))
                                               val ex_L83106 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L83106"))) )
                                               while (ex_L83106.hasNext) {
                                                   val sol_L83106 = ex_L83106.next
                                                   if(sol_L83106.result) {
                                                   vars += ("Subaction" -> sol_L83106.bindings("L83106").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_comp_conditions_score_only_failure_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Subaction")  )))
                                                                       adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Subaction")  )))

                                                   }
                                               }
                                           vars -= ("Subaction")
                                          adopt_achievement_comp_conditions_score_only_failure_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Action")  )))
                                          adopt_achievement_incompetence_calc_2.execute(Parameters(List( vars("A") , vars("Action")  )))


                     }


      }

      object adopt_achievement_competence_score_only_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("_"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("_"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_counters_1.execute(Parameters(List( vars("Action")  )))
                                          adopt_achievement_comp_conditions_score_only_succes_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Action")  )))
                                          adopt_achievement_competence_calc_2.execute(Parameters(List( vars("A") , vars("Action")  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_counters_1.execute(Parameters(List( vars("Action")  )))
                                               val ex_L39802 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L39802"))) )
                                               while (ex_L39802.hasNext) {
                                                   val sol_L39802 = ex_L39802.next
                                                   if(sol_L39802.result) {
                                                   vars += ("Subaction" -> sol_L39802.bindings("L39802").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_comp_conditions_score_only_succes_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Subaction")  )))
                                                                       adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Subaction")  )))

                                                   }
                                               }
                                           vars -= ("Subaction")
                                          adopt_achievement_comp_conditions_score_only_succes_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Action")  )))
                                          adopt_achievement_comp_subplans_2.execute(Parameters(List( vars("Action") , vars("Action")  )))
                                          adopt_achievement_competence_calc_2.execute(Parameters(List( vars("A") , vars("Action")  )))


                     }


      }

      object adopt_achievement_comp_conditions_score_only_succes_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Subaction" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("weight_knowledge",Seq[GenericTerm](vars("WK"))),StructTerm("weight_skill",Seq[GenericTerm](vars("WS"))))),StructTerm("weight_resource",Seq[GenericTerm](vars("WR"))))),StructTerm("threshold_knowledge",Seq[GenericTerm](vars("Subaction"),vars("TK"))))),StructTerm("threshold_skill",Seq[GenericTerm](vars("Subaction"),vars("TS"))))),StructTerm("threshold_resource",Seq[GenericTerm](vars("Subaction"),vars("TR"))))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Knowledge"),vars("K"))))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Skill"),vars("S"))))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Resource"),vars("R"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("WeightedKnowledge" ->  (vars("K") * vars("WK")) )
                                           vars += ("WeightedSkill" ->  (vars("S") * vars("WS")) )
                                           vars += ("WeightedResource" ->  (vars("R") * vars("WR")) )
                                           vars += ("SubScore" ->  ( ( (vars("WeightedKnowledge") + vars("WeightedSkill"))  + vars("WeightedResource"))  /  ( (vars("WK") + vars("WS"))  + vars("WR")) ) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Score-only: ") + vars("A"))  + StringTerm(" for "))  + vars("Subaction"))  + StringTerm(" = "))  + vars("SubScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),IntTerm(1)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("SubScore")))),GoalParser)


                     }


      }

      object adopt_achievement_comp_conditions_score_only_failure_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Subaction" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("weight_knowledge",Seq[GenericTerm](vars("WK"))),StructTerm("weight_skill",Seq[GenericTerm](vars("WS"))))),StructTerm("weight_resource",Seq[GenericTerm](vars("WR"))))),StructTerm("threshold_knowledge",Seq[GenericTerm](vars("Subaction"),vars("TK"))))),StructTerm("threshold_skill",Seq[GenericTerm](vars("Subaction"),vars("TS"))))),StructTerm("threshold_resource",Seq[GenericTerm](vars("Subaction"),vars("TR"))))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Knowledge"),vars("K"))))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Skill"),vars("S"))))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("Resource"),vars("R"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("WeightedKnowledge" ->  (vars("K") * vars("WK")) )
                                           vars += ("WeightedSkill" ->  (vars("S") * vars("WS")) )
                                           vars += ("WeightedResource" ->  (vars("R") * vars("WR")) )
                                           vars += ("SubScore" ->  ( ( (vars("WeightedKnowledge") + vars("WeightedSkill"))  + vars("WeightedResource"))  /  ( (vars("WK") + vars("WS"))  + vars("WR")) ) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Score-only: ") + vars("A"))  + StringTerm(" for "))  + vars("Subaction"))  + StringTerm(" = "))  + vars("SubScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sub_comp",Seq[GenericTerm](vars("Subaction"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence_sub",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("SubScore")))),GoalParser)


                     }


      }

      object adopt_achievement_update_competence_succes_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("goal",Seq[GenericTerm](vars("A"),vars("Action"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intended to go "))  + vars("Action"))  + StringTerm(" and succeeded.")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competent",Seq[GenericTerm](vars("A"),vars("Action")))),GoalParser)
                                               val ex_L75496 = executionContext.beliefBase.bufferedQuery( StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("L75496"),vars("X"))) )
                                               while (ex_L75496.hasNext) {
                                                   val sol_L75496 = ex_L75496.next
                                                   if(sol_L75496.result) {
                                                   vars += ("Knowledge" -> sol_L75496.bindings("L75496").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Knowledge")  )))

                                                   }
                                               }
                                           vars -= ("Knowledge")
                                               val ex_L50420 = executionContext.beliefBase.bufferedQuery( StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("L50420"),vars("X"))) )
                                               while (ex_L50420.hasNext) {
                                                   val sol_L50420 = ex_L50420.next
                                                   if(sol_L50420.result) {
                                                   vars += ("Resource" -> sol_L50420.bindings("L50420").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Resource")  )))

                                                   }
                                               }
                                           vars -= ("Resource")
                                               val ex_L34745 = executionContext.beliefBase.bufferedQuery( StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("L34745"),vars("X"))) )
                                               while (ex_L34745.hasNext) {
                                                   val sol_L34745 = ex_L34745.next
                                                   if(sol_L34745.result) {
                                                   vars += ("Skill" -> sol_L34745.bindings("L34745").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Skill")  )))

                                                   }
                                               }
                                           vars -= ("Skill")
                                               val ex_L80584 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L80584"))) )
                                               while (ex_L80584.hasNext) {
                                                   val sol_L80584 = ex_L80584.next
                                                   if(sol_L80584.result) {
                                                   vars += ("Subaction" -> sol_L80584.bindings("L80584").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("Subaction"))))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intended to go "))  + vars("Subaction"))  + StringTerm(" and succeeded.")) )))
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competent",Seq[GenericTerm](vars("A"),vars("Subaction")))),GoalParser)
                                                                            val ex_L16017 = executionContext.beliefBase.bufferedQuery( StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("L16017"),vars("X"))) )
                                                                            while (ex_L16017.hasNext) {
                                                                                val sol_L16017 = ex_L16017.next
                                                                                if(sol_L16017.result) {
                                                                                vars += ("Knowledge" -> sol_L16017.bindings("L16017").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("Knowledge"),vars("X"))))
                                                                                                     BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Knowledge"),vars("X")))),GoalParser)
                                                                                                    adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Subaction") , vars("Knowledge")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Knowledge")
                                                                            val ex_L80057 = executionContext.beliefBase.bufferedQuery( StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("L80057"),vars("X"))) )
                                                                            while (ex_L80057.hasNext) {
                                                                                val sol_L80057 = ex_L80057.next
                                                                                if(sol_L80057.result) {
                                                                                vars += ("Resource" -> sol_L80057.bindings("L80057").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("Resource"),vars("X"))))
                                                                                                     BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Resource"),vars("X")))),GoalParser)
                                                                                                    adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Subaction") , vars("Resource")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Resource")
                                                                            val ex_L94669 = executionContext.beliefBase.bufferedQuery( StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Subaction"),vars("L94669"),vars("X"))) )
                                                                            while (ex_L94669.hasNext) {
                                                                                val sol_L94669 = ex_L94669.next
                                                                                if(sol_L94669.result) {
                                                                                vars += ("Skill" -> sol_L94669.bindings("L94669").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("Skill"),vars("X"))))
                                                                                                     BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Skill"),vars("X")))),GoalParser)
                                                                                                    adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Subaction") , vars("Skill")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Skill")

                                                   }
                                               }
                                           vars -= ("Subaction")


                     }


      }

      object adopt_achievement_update_competence_failures_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("goal",Seq[GenericTerm](vars("A"),vars("Action"))),StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Action"),vars("Reason"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intended to go "))  + vars("Action"))  + StringTerm(" and failed.")) )))
                                               val ex_L70193 = executionContext.beliefBase.bufferedQuery( StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Action"),vars("L70193"))) )
                                               while (ex_L70193.hasNext) {
                                                   val sol_L70193 = ex_L70193.next
                                                   if(sol_L70193.result) {
                                                   vars += ("Reason" -> sol_L70193.bindings("L70193").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" failed because of "))  + vars("Reason"))  + StringTerm(".")) )))
                                                                       adopt_achievement_update_competence_failure_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Reason")  )))

                                                   }
                                               }
                                           vars -= ("Reason")


                     }


      }

      object adopt_achievement_update_competence_failure_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r2 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r3 = executionContext.beliefBase.query(StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r4 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end



                 //plan 5 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r5 = executionContext.beliefBase.query(StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Action"),vars("Condition"),vars("X"))))

                         if (r5.result) {
                             r5.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan5(vars)
                             return
                          }

                          // plan 5 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("Low"),vars("X"))))
                                          if(( ( (vars("X") < vars("High"))  &&  (vars("X") < vars("Low")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)

                                          }
                                                               else if(( (vars("X") < vars("High")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("X")))),GoalParser)

                                                               }



                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),IntTerm(0),vars("X"))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("Low"),vars("X"))))
                                          if(( ( (vars("X") < vars("High"))  &&  (vars("X") < vars("Low")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)

                                          }
                                                               else if(( (vars("X") < vars("High")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("X")))),GoalParser)

                                                               }



                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),IntTerm(0),vars("X"))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),vars("Low"),vars("X"))))
                                          if(( ( (vars("X") < vars("High"))  &&  (vars("X") < vars("Low")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](IntTerm(0),vars("X")))),GoalParser)

                                          }
                                                               else if(( (vars("X") < vars("High")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("X")))),GoalParser)

                                                               }



                     }
                      def plan5(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(vars("A"),vars("Condition"),IntTerm(0),vars("X"))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)


                     }


      }





 }
object competence_companion { 
   def create() = new competence().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new competence(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new competence(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new competence(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
