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

 class decisionCosinesim  (coms: AgentCommunicationLayer = new  DefaultCommunications,
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

                   case decisionCosinesim.this.adopt_belief_trustworthiness_4 =>
                     decisionCosinesim.this.adopt_belief_trustworthiness_4.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_belief_untrustworthiness_4 =>
                     decisionCosinesim.this.adopt_belief_untrustworthiness_4.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_process_all_agents_and_goals_0 =>
                     decisionCosinesim.this.adopt_achievement_process_all_agents_and_goals_0.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_initiate_selections_0 =>
                     decisionCosinesim.this.adopt_achievement_initiate_selections_0.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_acquire_scores_2 =>
                     decisionCosinesim.this.adopt_achievement_acquire_scores_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_belief_competence_3 =>
                     decisionCosinesim.this.adopt_belief_competence_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_belief_incompetence_3 =>
                     decisionCosinesim.this.adopt_belief_incompetence_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_belief_benevolence_offer_4 =>
                     decisionCosinesim.this.adopt_belief_benevolence_offer_4.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_belief_integrity_3 =>
                     decisionCosinesim.this.adopt_belief_integrity_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_maybe_update_agent_scores_2 =>
                     decisionCosinesim.this.adopt_achievement_maybe_update_agent_scores_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_update_agent_scores_2 =>
                     decisionCosinesim.this.adopt_achievement_update_agent_scores_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_print_vectors_2 =>
                     decisionCosinesim.this.adopt_achievement_print_vectors_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_relationships_2 =>
                     decisionCosinesim.this.adopt_achievement_send_relationships_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_agent_vector_5 =>
                     decisionCosinesim.this.adopt_achievement_send_agent_vector_5.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_goal_vector_4 =>
                     decisionCosinesim.this.adopt_achievement_send_goal_vector_4.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_trustor_vector_5 =>
                     decisionCosinesim.this.adopt_achievement_send_trustor_vector_5.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_trustworthiness_3 =>
                     decisionCosinesim.this.adopt_achievement_send_trustworthiness_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_untrustworthiness_3 =>
                     decisionCosinesim.this.adopt_achievement_send_untrustworthiness_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_benevolence_3 =>
                     decisionCosinesim.this.adopt_achievement_send_benevolence_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_competence_3 =>
                     decisionCosinesim.this.adopt_achievement_send_competence_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_integrity_3 =>
                     decisionCosinesim.this.adopt_achievement_send_integrity_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_incompetence_3 =>
                     decisionCosinesim.this.adopt_achievement_send_incompetence_3.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_send_relationship_4 =>
                     decisionCosinesim.this.adopt_achievement_send_relationship_4.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_select_agent_for_goal_2 =>
                     decisionCosinesim.this.adopt_achievement_select_agent_for_goal_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_maybe_update_trust_for_selected_2 =>
                     decisionCosinesim.this.adopt_achievement_maybe_update_trust_for_selected_2.execute(message.params.asInstanceOf[Parameters])

                   case decisionCosinesim.this.adopt_achievement_update_overall_trust_2 =>
                     decisionCosinesim.this.adopt_achievement_update_overall_trust_2.execute(message.params.asInstanceOf[Parameters])


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

         override def agent_type: String = "decisionCosinesim"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("process_all_agents_and_goals",Seq[GenericTerm](  ))


         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("agent",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]())))
           ,
            StructTerm("trustor",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]())))
           ,
            StructTerm("trust",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("trust",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("trust",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("goal",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("competence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("competence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("competence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("incompetence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7),DoubleTerm(0.9)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.5),DoubleTerm(0.7)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.6),DoubleTerm(0.8)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.85)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.75)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.65)))
           ,
            StructTerm("trustworthiness",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.85),StringTerm("above_threshold")))
           ,
            StructTerm("trustworthiness",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7),StringTerm("above_threshold")))
           ,
            StructTerm("trustworthiness",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.6),StringTerm("below_threshold")))
           ,
            StructTerm("untrustworthiness",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.4),StringTerm("below_threshold")))
           ,
            StructTerm("competence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.6),DoubleTerm(0.8)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("competence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.4),DoubleTerm(0.6)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("incompetence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("competence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("benevolence_offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.5),DoubleTerm(0.7)))
           ,
            StructTerm("integrity",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.75)))
           ,
            StructTerm("trustworthiness",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.75),StringTerm("above_threshold")))
           ,
            StructTerm("trustworthiness",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.6),StringTerm("above_threshold")))
           ,
            StructTerm("trustworthiness",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.55),StringTerm("below_threshold")))
           ,
            StructTerm("untrustworthiness",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.45),StringTerm("below_threshold")))
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
            StructTerm("goal_scores",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.75),DoubleTerm(0.85),DoubleTerm(0.9)))
           ,
            StructTerm("goal_scores",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.65),DoubleTerm(0.8),DoubleTerm(0.85)))
           ,
            StructTerm("trustor_scores",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7),DoubleTerm(0.8),DoubleTerm(0.85)))
           ,
            StructTerm("trustor_scores",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.6),DoubleTerm(0.75),DoubleTerm(0.8)))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore"))),StructTerm(",",Seq[GenericTerm](StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("Bmin"),vars("Bmax"))),StructTerm("is",Seq[GenericTerm](vars("BScore"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("Bmin"),vars("Bmax"))),IntTerm(2)))))))))


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
                    
                                   if(t.matchOnlyFunctorAndArity("process_all_agents_and_goals",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_process_all_agents_and_goals_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("initiate_selections",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_initiate_selections_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("acquire_scores",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_acquire_scores_2, args, ref))
                                   } else      
                                   if(t.matchOnlyFunctorAndArity("maybe_update_agent_scores",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_maybe_update_agent_scores_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_agent_scores",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_agent_scores_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("print_vectors",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_print_vectors_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_relationships",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_relationships_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_agent_vector",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_agent_vector_5, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_goal_vector",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_goal_vector_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_trustor_vector",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_trustor_vector_5, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_trustworthiness",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_trustworthiness_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_untrustworthiness",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_untrustworthiness_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_benevolence",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_benevolence_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_competence",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_competence_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_integrity",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_integrity_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_incompetence",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_incompetence_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_relationship",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_relationship_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("select_agent_for_goal",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_select_agent_for_goal_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("maybe_update_trust_for_selected",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_maybe_update_trust_for_selected_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_overall_trust",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_overall_trust_2, args, ref))
                                   } else   {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                   if(t.matchOnlyFunctorAndArity("trustworthiness",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_trustworthiness_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("untrustworthiness",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_untrustworthiness_4, args, ref))
                                   } else     
                                   if(t.matchOnlyFunctorAndArity("competence",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_competence_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("incompetence",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_incompetence_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("benevolence_offer",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_benevolence_offer_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("integrity",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_integrity_3, args, ref))
                                   } else                    {
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


      object adopt_belief_trustworthiness_4 extends IGoal {

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
                         vars +=(   "Agent" -> params.l_params(0))
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "Score" -> params.l_params(2))
                          vars +=(   "Reason" -> params.l_params(3))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( (StringTerm(" - Agent: ") + vars("Agent"))  + StringTerm(", Goal: "))  + vars("Goal"))  + StringTerm(", Score: "))  + vars("Score"))  + StringTerm(", Reason: "))  + vars("Reason")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("trustworthiness",Seq[GenericTerm](vars("Agent"),vars("Goal"),vars("_"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("trustworthiness",Seq[GenericTerm](vars("Agent"),vars("Goal"),vars("Score"),vars("Reason")))),GoalParser)


                     }


      }

      object adopt_belief_untrustworthiness_4 extends IGoal {

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
                         vars +=(   "Agent" -> params.l_params(0))
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "UntrustworthinessFactor" -> params.l_params(2))
                          vars +=(   "Reason" -> params.l_params(3))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( (StringTerm(" - Agent: ") + vars("Agent"))  + StringTerm(", Goal: "))  + vars("Goal"))  + StringTerm(", Score: "))  + vars("UntrustworthinessFactor"))  + StringTerm(", Reason: "))  + vars("Reason")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("untrustworthiness",Seq[GenericTerm](vars("Agent"),vars("Goal"),vars("_"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("untrustworthiness",Seq[GenericTerm](vars("Agent"),vars("Goal"),vars("UntrustworthinessFactor"),vars("Reason")))),GoalParser)


                     }


      }

      object adopt_achievement_process_all_agents_and_goals_0 extends IGoal {

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm(": Starting to process all agents and goals for trustworthiness calculation."))))
                                               val ex_L89429 = executionContext.beliefBase.bufferedQuery( StructTerm("agent",Seq[GenericTerm](vars("L89429"))) )
                                               while (ex_L89429.hasNext) {
                                                   val sol_L89429 = ex_L89429.next
                                                   if(sol_L89429.result) {
                                                   vars += ("A" -> sol_L89429.bindings("L89429").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm(": Processing agent: ") + vars("A")) )))
                                                                            val ex_L98616 = executionContext.beliefBase.bufferedQuery( StructTerm("goal",Seq[GenericTerm](vars("A"),vars("L98616"))) )
                                                                            while (ex_L98616.hasNext) {
                                                                                val sol_L98616 = ex_L98616.next
                                                                                if(sol_L98616.result) {
                                                                                vars += ("Goal" -> sol_L98616.bindings("L98616").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm(": Processing goal: ") + vars("Goal"))  + StringTerm(" for agent: "))  + vars("A")) )))
                                                                                                    adopt_achievement_update_agent_scores_2.execute(Parameters(List( vars("A") , vars("Goal")  )))
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm(": Updated scores for agent ") + vars("A"))  + StringTerm(" on goal "))  + vars("Goal")) )))

                                                                                }
                                                                            }
                                                                        vars -= ("Goal")

                                                   }
                                               }
                                           vars -= ("A")
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm(": Finished processing all agents and goals. Triggering selections."))))
                                          adopt_achievement_initiate_selections_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_achievement_initiate_selections_0 extends IGoal {

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Initiating agent selection process..."))))
                                               val ex_L3112 = executionContext.beliefBase.bufferedQuery( StructTerm("trustor",Seq[GenericTerm](vars("L3112"))) )
                                               while (ex_L3112.hasNext) {
                                                   val sol_L3112 = ex_L3112.next
                                                   if(sol_L3112.result) {
                                                   vars += ("Trustor" -> sol_L3112.bindings("L3112").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Processing trustor: ") + vars("Trustor")) )))
                                                                            val ex_L19593 = executionContext.beliefBase.bufferedQuery( StructTerm("trustor_scores",Seq[GenericTerm](vars("Trustor"),vars("L19593"),vars("TB"),vars("TC"),vars("TI"))) )
                                                                            while (ex_L19593.hasNext) {
                                                                                val sol_L19593 = ex_L19593.next
                                                                                if(sol_L19593.result) {
                                                                                vars += ("Goal" -> sol_L19593.bindings("L19593").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Selecting agent for goal: ") + vars("Goal"))  + StringTerm(" for trustor: "))  + vars("Trustor")) )))
                                                                                                    adopt_achievement_select_agent_for_goal_2.execute(Parameters(List( vars("Goal") , vars("Trustor")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Goal")

                                                   }
                                               }
                                           vars -= ("Trustor")


                     }


      }

      object adopt_achievement_acquire_scores_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("competence_provider_agent",Seq[GenericTerm](vars("CPAgent"))),StructTerm("benevolence_provider_agent",Seq[GenericTerm](vars("BPAgent"))))),StructTerm("integrity_provider_agent",Seq[GenericTerm](vars("IPAgent"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("CPAgent"),StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("CScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("CPAgent"),StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("InCScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("BPAgent"),StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScoremin"),vars("BScoremax"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.ask(vars("IPAgent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm(": Successfully asked for all scores for ") + vars("A"))  + StringTerm(", "))  + vars("Goal")) )))


                     }


      }

      object adopt_belief_competence_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "CScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Received competence for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("CScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("CScore")))),GoalParser)
                                          adopt_achievement_maybe_update_agent_scores_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_belief_incompetence_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "InCScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Received incompetence for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("InCScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("InCScore")))),GoalParser)
                                          adopt_achievement_maybe_update_agent_scores_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_belief_benevolence_offer_4 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "BScoremin" -> params.l_params(2))
                          vars +=(   "BScoremax" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm("is",Seq[GenericTerm](vars("BScore"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](vars("BScoremin"),vars("BScoremax"))),IntTerm(2))))))

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

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( (StringTerm("Received benevolence offer for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": min="))  + vars("BScoremin"))  + StringTerm(", max="))  + vars("BScoremax"))  + StringTerm(", mean="))  + vars("BScore")) )))
                                          adopt_achievement_maybe_update_agent_scores_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_belief_integrity_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "IScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Received integrity for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("IScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore")))),GoalParser)
                                          adopt_achievement_maybe_update_agent_scores_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_maybe_update_agent_scores_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"))))),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"))))))

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

                                          adopt_achievement_update_agent_scores_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_update_agent_scores_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("competence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("CScore"))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore"))))),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( (StringTerm(": Successfully acquired all scores for ") + vars("A"))  + StringTerm(", "))  + vars("Goal"))  + StringTerm(". C="))  + vars("CScore"))  + StringTerm(", B="))  + vars("BScore"))  + StringTerm(", I="))  + vars("IScore")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("agent_scores",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"),vars("_"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("agent_scores",Seq[GenericTerm](vars("A"),vars("Goal"),vars("BScore"),vars("CScore"),vars("IScore")))),GoalParser)
                                          adopt_achievement_print_vectors_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_print_vectors_2 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("agent_scores",Seq[GenericTerm](vars("A"),vars("Goal"),vars("B"),vars("C"),vars("I"))),StructTerm("goal_scores",Seq[GenericTerm](vars("Goal"),vars("GB"),vars("GC"),vars("GI"))))),StructTerm("trustor_scores",Seq[GenericTerm](vars("Trustor"),vars("Goal"),vars("TB"),vars("TC"),vars("TI"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("Agent vector: [") + vars("B"))  + StringTerm(", "))  + vars("C"))  + StringTerm(", "))  + vars("I"))  + StringTerm("]")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("Goal vector: [") + vars("GB"))  + StringTerm(", "))  + vars("GC"))  + StringTerm(", "))  + vars("GI"))  + StringTerm("]")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Sending agent vector for ") + vars("A"))  + StringTerm(" and goal "))  + vars("Goal")) )))
                                          adopt_achievement_send_agent_vector_5.execute(Parameters(List( vars("A") , vars("Goal") , vars("B") , vars("C") , vars("I")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Sending goal vector for goal ") + vars("Goal")) )))
                                          adopt_achievement_send_goal_vector_4.execute(Parameters(List( vars("Goal") , vars("GB") , vars("GC") , vars("GI")  )))
                                               val ex_L35278 = executionContext.beliefBase.bufferedQuery( StructTerm("trustor_scores",Seq[GenericTerm](vars("L35278"),vars("Goal"),vars("TB"),vars("TC"),vars("TI"))) )
                                               while (ex_L35278.hasNext) {
                                                   val sol_L35278 = ex_L35278.next
                                                   if(sol_L35278.result) {
                                                   vars += ("Trustor" -> sol_L35278.bindings("L35278").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("Trustor vector: [") + vars("TB"))  + StringTerm(", "))  + vars("TC"))  + StringTerm(", "))  + vars("TI"))  + StringTerm("]")) )))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Sending trustor vector for trustor ") + vars("Trustor"))  + StringTerm(" and goal "))  + vars("Goal")) )))
                                                                       adopt_achievement_send_trustor_vector_5.execute(Parameters(List( vars("Trustor") , vars("Goal") , vars("TB") , vars("TC") , vars("TI")  )))

                                                   }
                                               }
                                           vars -= ("Trustor")
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Sending all scores to Java for agent ") + vars("A"))  + StringTerm(" and goal "))  + vars("Goal")) )))
                                          adopt_achievement_send_benevolence_3.execute(Parameters(List( vars("A") , vars("Goal") , vars("B")  )))
                                          adopt_achievement_send_competence_3.execute(Parameters(List( vars("A") , vars("Goal") , vars("C")  )))
                                          adopt_achievement_send_integrity_3.execute(Parameters(List( vars("A") , vars("Goal") , vars("I")  )))
                                               val ex_L77362 = executionContext.beliefBase.bufferedQuery( StructTerm("incompetence",Seq[GenericTerm](vars("A"),vars("Goal"),vars("L77362"))) )
                                               while (ex_L77362.hasNext) {
                                                   val sol_L77362 = ex_L77362.next
                                                   if(sol_L77362.result) {
                                                   vars += ("InComp" -> sol_L77362.bindings("L77362").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Sending incompetence for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("InComp")) )))
                                                                       adopt_achievement_send_incompetence_3.execute(Parameters(List( vars("A") , vars("Goal") , vars("InComp")  )))

                                                   }
                                               }
                                           vars -= ("InComp")
                                               val ex_L21326 = executionContext.beliefBase.bufferedQuery( StructTerm("trustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("L21326"),vars("_"))) )
                                               while (ex_L21326.hasNext) {
                                                   val sol_L21326 = ex_L21326.next
                                                   if(sol_L21326.result) {
                                                   vars += ("TScore" -> sol_L21326.bindings("L21326").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Sending trustworthiness for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("TScore")) )))
                                                                       adopt_achievement_send_trustworthiness_3.execute(Parameters(List( vars("A") , vars("Goal") , vars("TScore")  )))

                                                   }
                                               }
                                           vars -= ("TScore")
                                               val ex_L37796 = executionContext.beliefBase.bufferedQuery( StructTerm("untrustworthiness",Seq[GenericTerm](vars("A"),vars("Goal"),vars("L37796"),vars("_"))) )
                                               while (ex_L37796.hasNext) {
                                                   val sol_L37796 = ex_L37796.next
                                                   if(sol_L37796.result) {
                                                   vars += ("UT" -> sol_L37796.bindings("L37796").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Sending untrustworthiness for ") + vars("A"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("UT")) )))
                                                                       adopt_achievement_send_untrustworthiness_3.execute(Parameters(List( vars("A") , vars("Goal") , vars("UT")  )))

                                                   }
                                               }
                                           vars -= ("UT")
                                          adopt_achievement_send_relationships_2.execute(Parameters(List( vars("A") , vars("Trustor")  )))


                     }


      }

      object adopt_achievement_send_relationships_2 extends IGoal {

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
                          vars +=(   "Trustor" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L74389 = executionContext.beliefBase.bufferedQuery( StructTerm("relationship",Seq[GenericTerm](vars("L74389"),vars("A"),vars("Type"))) )
                                               while (ex_L74389.hasNext) {
                                                   val sol_L74389 = ex_L74389.next
                                                   if(sol_L74389.result) {
                                                   vars += ("Trustor" -> sol_L74389.bindings("L74389").asInstanceOf[GenericTerm])
                                                                            val ex_L39205 = executionContext.beliefBase.bufferedQuery( StructTerm("relationship",Seq[GenericTerm](vars("Trustor"),vars("A"),vars("L39205"))) )
                                                                            while (ex_L39205.hasNext) {
                                                                                val sol_L39205 = ex_L39205.next
                                                                                if(sol_L39205.result) {
                                                                                vars += ("Type" -> sol_L39205.bindings("L39205").asInstanceOf[GenericTerm])
                                                                                                         val ex_L98937 = executionContext.beliefBase.bufferedQuery( StructTerm("relationship_strength",Seq[GenericTerm](vars("Trustor"),vars("A"),vars("L98937"))) )
                                                                                                         while (ex_L98937.hasNext) {
                                                                                                             val sol_L98937 = ex_L98937.next
                                                                                                             if(sol_L98937.result) {
                                                                                                             vars += ("Strength" -> sol_L98937.bindings("L98937").asInstanceOf[GenericTerm])
                                                                                                                                 PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( (StringTerm("Sending relationship for ") + vars("Trustor"))  + StringTerm(" with agent "))  + vars("A"))  + StringTerm(": Type="))  + vars("Type"))  + StringTerm(", Strength="))  + vars("Strength")) )))
                                                                                                                                 adopt_achievement_send_relationship_4.execute(Parameters(List( vars("Trustor") , vars("A") , vars("Type") , vars("Strength")  )))

                                                                                                             }
                                                                                                         }
                                                                                                     vars -= ("Strength")

                                                                                }
                                                                            }
                                                                        vars -= ("Type")

                                                   }
                                               }
                                           vars -= ("Trustor")


                     }


      }

      object adopt_achievement_send_agent_vector_5 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "B" -> params.l_params(2))
                          vars +=(   "C" -> params.l_params(3))
                          vars +=(   "I" -> params.l_params(4))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addAgentVector(vars("A"),vars("Goal"),vars("B"),vars("C"),vars("I"))))


                     }


      }

      object adopt_achievement_send_goal_vector_4 extends IGoal {

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
                         vars +=(   "Goal" -> params.l_params(0))
                          vars +=(   "GB" -> params.l_params(1))
                          vars +=(   "GC" -> params.l_params(2))
                          vars +=(   "GI" -> params.l_params(3))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addGoalVector(vars("Goal"),vars("GB"),vars("GC"),vars("GI"))))


                     }


      }

      object adopt_achievement_send_trustor_vector_5 extends IGoal {

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
                         vars +=(   "Trustor" -> params.l_params(0))
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "TB" -> params.l_params(2))
                          vars +=(   "TC" -> params.l_params(3))
                          vars +=(   "TI" -> params.l_params(4))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addTrustorVector(vars("Trustor"),vars("Goal"),vars("TB"),vars("TC"),vars("TI"))))


                     }


      }

      object adopt_achievement_send_trustworthiness_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "TScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addTrustworthiness(vars("A"),vars("Goal"),vars("TScore"))))


                     }


      }

      object adopt_achievement_send_untrustworthiness_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "UScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addUntrustworthiness(vars("A"),vars("Goal"),vars("UScore"))))


                     }


      }

      object adopt_achievement_send_benevolence_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "B" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addBenevolence(vars("A"),vars("Goal"),vars("B"))))


                     }


      }

      object adopt_achievement_send_competence_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "C" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addCompetence(vars("A"),vars("Goal"),vars("C"))))


                     }


      }

      object adopt_achievement_send_integrity_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "I" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addIntegrity(vars("A"),vars("Goal"),vars("I"))))


                     }


      }

      object adopt_achievement_send_incompetence_3 extends IGoal {

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "InCScore" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addIncompetence(vars("A"),vars("Goal"),vars("InCScore"))))


                     }


      }

      object adopt_achievement_send_relationship_4 extends IGoal {

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
                         vars +=(   "Trustor" -> params.l_params(0))
                          vars +=(   "A" -> params.l_params(1))
                          vars +=(   "Type" -> params.l_params(2))
                          vars +=(   "Strength" -> params.l_params(3))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => nl.uva.agentselection.AgentSelectionLogic.addRelationship(vars("Trustor"),vars("A"),vars("Type"),vars("Strength"))))


                     }


      }

      object adopt_achievement_select_agent_for_goal_2 extends IGoal {

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
                         vars +=(   "Goal" -> params.l_params(0))
                          vars +=(   "Trustor" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("SelectedAgent" -> nl.uva.agentselection.AgentSelectionLogic.startHierarchicalSelection(vars("Goal"),vars("Trustor")))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Selected agent for ") + vars("Goal"))  + StringTerm(" by "))  + vars("Trustor"))  + StringTerm(": "))  + vars("SelectedAgent")) )))
                                          adopt_achievement_maybe_update_trust_for_selected_2.execute(Parameters(List( vars("SelectedAgent") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_maybe_update_trust_for_selected_2 extends IGoal {

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
                         vars +=(   "SelectedAgent" -> params.l_params(0))
                          vars +=(   "Goal" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("trustworthiness",Seq[GenericTerm](vars("SelectedAgent"),vars("Goal"),vars("TScore"),vars("Reason"))),StructTerm("agent_scores",Seq[GenericTerm](vars("SelectedAgent"),vars("Goal"),vars("BScore"),vars("CScore"),vars("IScore"))))),StructTerm("relationship",Seq[GenericTerm](vars("Trustor"),vars("SelectedAgent"),vars("Type"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("-------------------------------------------------"))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Selected agent: ") + vars("SelectedAgent"))  + StringTerm(" with trustworthiness: "))  + vars("TScore"))  + StringTerm(" Reason: "))  + vars("Reason")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( (StringTerm("Scores for ") + vars("SelectedAgent"))  + StringTerm(" on goal "))  + vars("Goal"))  + StringTerm(": B="))  + vars("BScore"))  + StringTerm(", C="))  + vars("CScore"))  + StringTerm(", I="))  + vars("IScore")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Relationship with trustor: ") + vars("Trustor"))  + StringTerm(", Type: "))  + vars("Type")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("-------------------------------------------------"))))
                                               val ex_L5643 = executionContext.beliefBase.bufferedQuery( StructTerm("untrustworthiness",Seq[GenericTerm](vars("SelectedAgent"),vars("Goal"),vars("L5643"),vars("UReason"))) )
                                               while (ex_L5643.hasNext) {
                                                   val sol_L5643 = ex_L5643.next
                                                   if(sol_L5643.result) {
                                                   vars += ("UScore" -> sol_L5643.bindings("L5643").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( ( (StringTerm("Agent") + vars("SelectedAgent"))  + StringTerm("for "))  + vars("Goal"))  + StringTerm(": "))  + StringTerm(" has minimum Untrustworthinessfactor: "))  + vars("UScore"))  + StringTerm(")"))  + StringTerm("("))  + vars("UReason"))  + StringTerm(")")) )))

                                                   }
                                               }
                                           vars -= ("UScore")
                                               val ex_L27028 = executionContext.beliefBase.bufferedQuery( StructTerm("incompetence",Seq[GenericTerm](vars("SelectedAgent"),vars("Goal"),vars("L27028"))) )
                                               while (ex_L27028.hasNext) {
                                                   val sol_L27028 = ex_L27028.next
                                                   if(sol_L27028.result) {
                                                   vars += ("InCScore" -> sol_L27028.bindings("L27028").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Agent") + vars("SelectedAgent"))  + StringTerm(" for "))  + vars("Goal"))  + StringTerm("has minimum incompetence score: "))  + vars("InCScore")) )))

                                                   }
                                               }
                                           vars -= ("InCScore")
                                           vars += ("AgentGoalSim" -> nl.uva.agentselection.AgentSelectionLogic.getAgentGoalCosineSimilarity(vars("SelectedAgent"),vars("Goal")))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Cosine similarity (Agent-Goal) for ") + vars("SelectedAgent"))  + StringTerm(" and "))  + vars("Goal"))  + StringTerm(": "))  + vars("AgentGoalSim")) )))
                                           vars += ("TrustorAgentSim" -> nl.uva.agentselection.AgentSelectionLogic.getTrustorAgentCosineSimilarity(vars("Trustor"),vars("SelectedAgent"),vars("Goal")))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( (StringTerm("Cosine similarity (Trustor-Agent) for ") + vars("Trustor"))  + StringTerm(" and "))  + vars("SelectedAgent"))  + StringTerm(" on "))  + vars("Goal"))  + StringTerm(": "))  + vars("TrustorAgentSim")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("-------------------------------------------------"))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Updating overall trust for ") + vars("SelectedAgent"))  + StringTerm(" based on goal: "))  + vars("Goal")) )))
                                          adopt_achievement_update_overall_trust_2.execute(Parameters(List( vars("SelectedAgent") , vars("TScore")  )))


                     }


      }

      object adopt_achievement_update_overall_trust_2 extends IGoal {

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
                          vars +=(   "Outcome" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("A"),vars("OldTrust"))))

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

                                           vars += ("LearningRate" -> DoubleTerm(0.1))
                                           vars += ("NewTrust" ->  (vars("OldTrust") +  (vars("LearningRate") *  (vars("Outcome") - vars("OldTrust")) ) ) )
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("trust",Seq[GenericTerm](vars("A"),vars("OldTrust")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("trust",Seq[GenericTerm](vars("A"),vars("NewTrust")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Updated trust for ") + vars("A"))  + StringTerm(": "))  + vars("NewTrust")) )))


                     }


      }





 }
object decisionCosinesim_companion { 
   def create() = new decisionCosinesim().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new decisionCosinesim(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new decisionCosinesim(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new decisionCosinesim(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
