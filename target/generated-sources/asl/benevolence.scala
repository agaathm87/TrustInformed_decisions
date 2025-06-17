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

 class benevolence  (coms: AgentCommunicationLayer = new  DefaultCommunications,
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

                   case benevolence.this.adopt_test_benevolence_offer_4 =>
                     benevolence.this.adopt_test_benevolence_offer_4.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_getnames_0 =>
                     benevolence.this.adopt_achievement_getnames_0.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_init_benevolence_counters_1 =>
                     benevolence.this.adopt_achievement_init_benevolence_counters_1.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_update_benevolence_1 =>
                     benevolence.this.adopt_achievement_update_benevolence_1.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_process_offers_1 =>
                     benevolence.this.adopt_achievement_process_offers_1.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_initialize_benevolence_2 =>
                     benevolence.this.adopt_achievement_initialize_benevolence_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_init_combined_weights_3 =>
                     benevolence.this.adopt_achievement_init_combined_weights_3.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_evaluate_offer_2 =>
                     benevolence.this.adopt_achievement_evaluate_offer_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_check_offer_response_2 =>
                     benevolence.this.adopt_achievement_check_offer_response_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_evaluate_offer_local_2 =>
                     benevolence.this.adopt_achievement_evaluate_offer_local_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_evaluate_offer_value_5 =>
                     benevolence.this.adopt_achievement_evaluate_offer_value_5.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_comp_values_2 =>
                     benevolence.this.adopt_achievement_comp_values_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_evaluate_offer_decision_4 =>
                     benevolence.this.adopt_achievement_evaluate_offer_decision_4.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_compute_benevolence_score_value_5 =>
                     benevolence.this.adopt_achievement_compute_benevolence_score_value_5.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_get_combined_weight_2 =>
                     benevolence.this.adopt_achievement_get_combined_weight_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_comp_sum_ben_3 =>
                     benevolence.this.adopt_achievement_comp_sum_ben_3.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_comp_total_ben_2 =>
                     benevolence.this.adopt_achievement_comp_total_ben_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_handle_acceptance_3 =>
                     benevolence.this.adopt_achievement_handle_acceptance_3.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_handle_rejection_2 =>
                     benevolence.this.adopt_achievement_handle_rejection_2.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_update_benevolence_reject_3 =>
                     benevolence.this.adopt_achievement_update_benevolence_reject_3.execute(message.params.asInstanceOf[Parameters])

                   case benevolence.this.adopt_achievement_update_benevolence_accept_4 =>
                     benevolence.this.adopt_achievement_update_benevolence_accept_4.execute(message.params.asInstanceOf[Parameters])


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

         override def agent_type: String = "benevolence"

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
            StructTerm("offer",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]())))
           ,
            StructTerm("offer",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer3",Seq[GenericTerm]())))
           ,
            StructTerm("offer",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("offer4",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
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
            StructTerm("value_weight",Seq[GenericTerm](StructTerm("fun",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("value_weight",Seq[GenericTerm](StructTerm("health",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(1.0)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.1)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.1)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("phi",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("benevolence",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]()),IntTerm(0),IntTerm(0)))
           ,
            StructTerm("reject",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]())))
           ,
            StructTerm("reject",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]()),StructTerm("health",Seq[GenericTerm]())))
           ,
            StructTerm("totalbenmin",Seq[GenericTerm](IntTerm(0)))
           ,
            StructTerm("totalbenmax",Seq[GenericTerm](IntTerm(0)))
           ,
            StructTerm("number_of_values",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("accepted_values",Seq[GenericTerm](vars("_"),IntTerm(0)))
           ,
            StructTerm("total_combined_weight",Seq[GenericTerm](IntTerm(0)))
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
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_benevolence",Seq[GenericTerm](vars("Agent"),vars("Value"))),StructTerm(";",Seq[GenericTerm](StructTerm("not",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("Agent"),vars("Value"),vars("_"),vars("_"))))),StructTerm("benevolence",Seq[GenericTerm](vars("Agent"),vars("Value"),vars("Bmin"),IntTerm(0)))))))


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
                                   if(t.matchOnlyFunctorAndArity("init_benevolence_counters",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_init_benevolence_counters_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_benevolence",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_benevolence_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("process_offers",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_process_offers_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("initialize_benevolence",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_initialize_benevolence_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("init_combined_weights",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_init_combined_weights_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("evaluate_offer",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_evaluate_offer_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("check_offer_response",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_check_offer_response_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("evaluate_offer_local",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_evaluate_offer_local_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("evaluate_offer_value",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_evaluate_offer_value_5, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_values",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_values_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("evaluate_offer_decision",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_evaluate_offer_decision_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("compute_benevolence_score_value",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_compute_benevolence_score_value_5, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("get_combined_weight",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_get_combined_weight_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_sum_ben",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_sum_ben_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("comp_total_ben",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_comp_total_ben_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("handle_acceptance",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_handle_acceptance_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("handle_rejection",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_handle_rejection_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_benevolence_reject",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_benevolence_reject_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_benevolence_accept",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_benevolence_accept_4, args, ref))
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
                                                   if(t.matchOnlyFunctorAndArity("benevolence_offer",4)) {
                                                     val args: Parameters = Parameters(t.terms.toList)
                                                     Option(SubGoalMessage(adopt_test_benevolence_offer_4, args, ref))
                                                   } else                       {
                            Option.empty[SubGoalMessage]
                            }
                        }
          override def create_unbelief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                                         {
                                     Option.empty[SubGoalMessage]
                                     }
                                 }



        }


      object adopt_test_benevolence_offer_4 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "Bmin" -> params.l_params(2))
                          vars +=(   "Bmax" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Bmin"),vars("Bmax"))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trustworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

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
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "Bmin" -> params.l_params(2))
                          vars +=(   "Bmax" -> params.l_params(3))

                         val r1 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"),vars("_"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Bmin"),vars("Bmax"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Bmin"),vars("Bmax"))))))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_update_benevolence_1.execute(Parameters(List( vars("A")  )))


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

                                               val ex_L94133 = executionContext.beliefBase.bufferedQuery( StructTerm("agent",Seq[GenericTerm](vars("L94133"))) )
                                               while (ex_L94133.hasNext) {
                                                   val sol_L94133 = ex_L94133.next
                                                   if(sol_L94133.result) {
                                                   vars += ("A" -> sol_L94133.bindings("L94133").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_update_benevolence_1.execute(Parameters(List( vars("A")  )))

                                                   }
                                               }
                                           vars -= ("A")


                     }


      }

      object adopt_achievement_init_benevolence_counters_1 extends IGoal {

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
                         vars +=(   "Offer" -> params.l_params(0))

                         val r0 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("_"))))))

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

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)


                     }


      }

      object adopt_achievement_update_benevolence_1 extends IGoal {

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

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))),StructTerm(">",Seq[GenericTerm](vars("Bmax"),IntTerm(0))))))

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

                         val r1 = executionContext.beliefBase.query(StructTerm("missing_or_zero_benevolence",Seq[GenericTerm](vars("A"),vars("Value"))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("------Updating benevolence of agent ") + vars("A"))  + StringTerm("------")) )))
                                          adopt_achievement_process_offers_1.execute(Parameters(List( vars("A")  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("------Missing or zero benevolence found for agent ") + vars("A"))  + StringTerm(" and value "))  + vars("Value"))  + StringTerm(". Initializing benevolence.------")) )))
                                          adopt_achievement_initialize_benevolence_2.execute(Parameters(List( vars("A") , vars("Value")  )))


                     }


      }

      object adopt_achievement_process_offers_1 extends IGoal {

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("------Processing offers for agent ") + vars("A"))  + StringTerm("------")) )))
                                               val ex_L25074 = executionContext.beliefBase.bufferedQuery( StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("L25074"))) )
                                               while (ex_L25074.hasNext) {
                                                   val sol_L25074 = ex_L25074.next
                                                   if(sol_L25074.result) {
                                                   vars += ("Offer" -> sol_L25074.bindings("L25074").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("We are now updating according to ") + vars("Offer"))  + StringTerm(".")) )))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("We dont know if ") + vars("Offer"))  + StringTerm(" is accepted. We will try to find out now.")) )))
                                                                       adopt_achievement_evaluate_offer_2.execute(Parameters(List( vars("A") , vars("Offer")  )))

                                                   }
                                               }
                                           vars -= ("Offer")


                     }


      }

      object adopt_achievement_initialize_benevolence_2 extends IGoal {

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
                          vars +=(   "Value" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("trustor",Seq[GenericTerm](vars("B"))),StructTerm("relationship",Seq[GenericTerm](vars("B"),vars("A"),vars("Type"))))),StructTerm("weight_relationship",Seq[GenericTerm](vars("Type"),vars("W"))))),StructTerm("relationship_strength",Seq[GenericTerm](vars("B"),vars("A"),vars("Strength"))))))

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
                          vars +=(   "Value" -> params.l_params(1))

                             plan1(vars)
                             return
                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("DefaultMin" ->  (vars("Strength") * vars("W")) )
                                               val ex_L50012 = executionContext.beliefBase.bufferedQuery( StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("L50012"),vars("_"),vars("_"))) )
                                               while (ex_L50012.hasNext) {
                                                   val sol_L50012 = ex_L50012.next
                                                   if(sol_L50012.result) {
                                                   vars += ("Value" -> sol_L50012.bindings("L50012").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( (StringTerm("Initialized benevolence for ") + vars("A"))  + StringTerm(" on "))  + vars("Value"))  + StringTerm(" from relationship with "))  + vars("B"))  + StringTerm(": ["))  + vars("DefaultMin"))  + StringTerm(", 1 ]")) )))
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("_"),vars("_")))),GoalParser)
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("DefaultMin"),IntTerm(1)))),GoalParser)

                                                   }
                                               }
                                           vars -= ("Value")
                                          adopt_achievement_process_offers_1.execute(Parameters(List( vars("A")  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L91260 = executionContext.beliefBase.bufferedQuery( StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("L91260"),vars("_"),vars("_"))) )
                                               while (ex_L91260.hasNext) {
                                                   val sol_L91260 = ex_L91260.next
                                                   if(sol_L91260.result) {
                                                   vars += ("Value" -> sol_L91260.bindings("L91260").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("No relationship data found. Using default benevolence [0, 1] for ") + vars("Value")) )))
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("_"),vars("_")))),GoalParser)
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),IntTerm(0),IntTerm(1)))),GoalParser)

                                                   }
                                               }
                                           vars -= ("Value")
                                          adopt_achievement_process_offers_1.execute(Parameters(List( vars("A")  )))


                     }


      }

      object adopt_achievement_init_combined_weights_3 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "NewPlan" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L3253 = executionContext.beliefBase.bufferedQuery( StructTerm("phi",Seq[GenericTerm](vars("A"),vars("L3253"),vars("NewPlan"),vars("_"))) )
                                               while (ex_L3253.hasNext) {
                                                   val sol_L3253 = ex_L3253.next
                                                   if(sol_L3253.result) {
                                                   vars += ("Value" -> sol_L3253.bindings("L3253").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_get_combined_weight_2.execute(Parameters(List( vars("Value") , vars("CombinedWv")  )))

                                                   }
                                               }
                                           vars -= ("Value")


                     }


      }

      object adopt_achievement_evaluate_offer_2 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))),StructTerm("accept",Seq[GenericTerm](vars("A"),vars("Offer"))))))

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
                          vars +=(   "Offer" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))),StructTerm("reject",Seq[GenericTerm](vars("A"),vars("Offer"),vars("_"))))))

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
                          vars +=(   "Offer" -> params.l_params(1))

                             plan2(vars)
                             return
                          // plan 2 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_benevolence_counters_1.execute(Parameters(List( vars("Offer")  )))
                                          adopt_achievement_init_combined_weights_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("NewPlan")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("The offer was accepted."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("OldPlan")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("NewPlan")))),GoalParser)
                                               val ex_L67916 = executionContext.beliefBase.bufferedQuery( StructTerm("phi",Seq[GenericTerm](vars("A"),vars("L67916"),vars("NewPlan"),vars("X1"))) )
                                               while (ex_L67916.hasNext) {
                                                   val sol_L67916 = ex_L67916.next
                                                   if(sol_L67916.result) {
                                                   vars += ("Value" -> sol_L67916.bindings("L67916").asInstanceOf[GenericTerm])
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),IntTerm(1)))),GoalParser)
                                                                       adopt_achievement_compute_benevolence_score_value_5.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))
                                                                       adopt_achievement_comp_sum_ben_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value")  )))
                                                                       adopt_achievement_comp_values_2.execute(Parameters(List( vars("A") , vars("Offer")  )))
                                                                       adopt_achievement_update_benevolence_accept_4.execute(Parameters(List( vars("A") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))

                                                   }
                                               }
                                           vars -= ("Value")
                                          adopt_achievement_comp_total_ben_2.execute(Parameters(List( vars("A") , vars("Offer")  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_init_benevolence_counters_1.execute(Parameters(List( vars("Offer")  )))
                                          adopt_achievement_init_combined_weights_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("NewPlan")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("The offer was rejected."))))
                                               val ex_L99317 = executionContext.beliefBase.bufferedQuery( StructTerm("reject",Seq[GenericTerm](vars("A"),vars("Offer"),vars("L99317"))) )
                                               while (ex_L99317.hasNext) {
                                                   val sol_L99317 = ex_L99317.next
                                                   if(sol_L99317.result) {
                                                   vars += ("Value" -> sol_L99317.bindings("L99317").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It was rejected on the basis of ") + vars("Value"))  + StringTerm(".")) )))
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),vars("_")))),GoalParser)
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)
                                                                       adopt_achievement_compute_benevolence_score_value_5.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))
                                                                       adopt_achievement_comp_sum_ben_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value")  )))
                                                                       adopt_achievement_comp_values_2.execute(Parameters(List( vars("A") , vars("Offer")  )))
                                                                       adopt_achievement_update_benevolence_reject_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value")  )))

                                                   }
                                               }
                                           vars -= ("Value")
                                          adopt_achievement_comp_total_ben_2.execute(Parameters(List( vars("A") , vars("Offer")  )))


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It is not known yet whether ") + vars("A"))  + StringTerm(" accepted or rejected the offer.")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("Asking ") + vars("A"))  + StringTerm(" if they accept offer "))  + vars("Offer"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("pending_offer_decision",Seq[GenericTerm](vars("Offer")))),GoalParser)
                                          adopt_achievement_check_offer_response_2.execute(Parameters(List( vars("A") , vars("Offer")  )))


                     }


      }

      object adopt_achievement_check_offer_response_2 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("pending_offer_decision",Seq[GenericTerm](vars("Offer"))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("No response received for offer ") + vars("Offer"))  + StringTerm(". Running local evaluation.")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("pending_offer_decision",Seq[GenericTerm](vars("Offer")))),GoalParser)
                                          adopt_achievement_evaluate_offer_local_2.execute(Parameters(List( vars("A") , vars("Offer")  )))


                     }


      }

      object adopt_achievement_evaluate_offer_local_2 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))))

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

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("totalbenmin",Seq[GenericTerm](vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("totalbenmin",Seq[GenericTerm](IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("totalbenmax",Seq[GenericTerm](vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("totalbenmax",Seq[GenericTerm](IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("total_combined_weight",Seq[GenericTerm](vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("total_combined_weight",Seq[GenericTerm](IntTerm(0)))),GoalParser)
                                          adopt_achievement_init_benevolence_counters_1.execute(Parameters(List( vars("Offer")  )))
                                          adopt_achievement_init_combined_weights_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("NewPlan")  )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It is not known yet whether ") + vars("A"))  + StringTerm(" accepted or rejected the offer.")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Evaluating offer: ") + vars("Offer")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Processing values for offer: ") + vars("Offer")) )))
                                               val ex_L69114 = executionContext.beliefBase.bufferedQuery( StructTerm("phi",Seq[GenericTerm](vars("A"),vars("L69114"),vars("NewPlan"),vars("Y"))) )
                                               while (ex_L69114.hasNext) {
                                                   val sol_L69114 = ex_L69114.next
                                                   if(sol_L69114.result) {
                                                   vars += ("Value" -> sol_L69114.bindings("L69114").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_evaluate_offer_value_5.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))
                                                                       adopt_achievement_compute_benevolence_score_value_5.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))
                                                                       adopt_achievement_comp_sum_ben_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value")  )))

                                                   }
                                               }
                                           vars -= ("Value")
                                          adopt_achievement_evaluate_offer_decision_4.execute(Parameters(List( vars("A") , vars("Offer") , vars("NewPlan") , vars("OldPlan")  )))


                     }


      }

      object adopt_achievement_evaluate_offer_value_5 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "Value" -> params.l_params(2))
                          vars +=(   "NewPlan" -> params.l_params(3))
                          vars +=(   "OldPlan" -> params.l_params(4))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))),StructTerm("is",Seq[GenericTerm](vars("Z"),StructTerm("+",Seq[GenericTerm](vars("Bmin"),StructTerm("/",Seq[GenericTerm](vars("Bmax"),IntTerm(2))))))))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("OldPlan"),vars("T"))))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("Y"))))))

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

                                           vars += ("Ben" ->  (vars("Y") + vars("Z")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Processing value: ") + vars("Value"))  + StringTerm(" for offer: "))  + vars("Offer")) )))
                                          if(( (vars("T") <= vars("Ben")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (vars("A") + StringTerm(" accepts value "))  + vars("Value")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),vars("_")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),IntTerm(1)))),GoalParser)

                                          }
                                           else {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (vars("A") + StringTerm(" rejects value "))  + vars("Value")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("reject",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),vars("_")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)

                                           }
                                          adopt_achievement_comp_values_2.execute(Parameters(List( vars("A") , vars("Offer")  )))


                     }


      }

      object adopt_achievement_comp_values_2 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("val_comp",Seq[GenericTerm](vars("Offer"),vars("ValComp"))),StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("NV"))))),StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),vars("AV"))))))

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

                                           vars += ("NewNV" ->  (vars("NV") + IntTerm(1)) )
                                           vars += ("NewAV" ->  (vars("AV") + vars("ValComp")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Updating counters for offer: ") + vars("Offer"))  + StringTerm(". Total values: "))  + vars("NewNV"))  + StringTerm(", Accepted values: "))  + vars("NewAV")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("NV")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("NewNV")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),vars("AV")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),vars("NewAV")))),GoalParser)


                     }


      }

      object adopt_achievement_evaluate_offer_decision_4 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "NewPlan" -> params.l_params(2))
                          vars +=(   "OldPlan" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("NV"))),StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),vars("AV"))))),StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Evaluating decision for offer: ") + vars("Offer")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Total values: ") + vars("NV"))  + StringTerm(", Accepted values: "))  + vars("AV")) )))
                                          if(( (vars("NV") == vars("AV")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (vars("A") + StringTerm(" accepts the offer: "))  + vars("Offer")) )))
                                                                  adopt_achievement_handle_acceptance_3.execute(Parameters(List( vars("A") , vars("NewPlan") , vars("OldPlan")  )))

                                          }
                                           else {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (vars("A") + StringTerm(" rejects the offer: "))  + vars("Offer")) )))
                                                                  adopt_achievement_handle_rejection_2.execute(Parameters(List( vars("A") , vars("Offer")  )))

                                           }
                                          adopt_achievement_comp_total_ben_2.execute(Parameters(List( vars("A") , vars("Offer")  )))


                     }


      }

      object adopt_achievement_compute_benevolence_score_value_5 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "Value" -> params.l_params(2))
                          vars +=(   "NewPlan" -> params.l_params(3))
                          vars +=(   "OldPlan" -> params.l_params(4))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("OldPlan"),vars("T"))))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("Y"))))))

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

                                           vars += ("Demotion" ->  (vars("T") - vars("Y")) )
                                           vars += ("BenMax" ->  (vars("Y") + vars("Bmax")) )
                                           vars += ("BenMin" ->  (vars("Y") + vars("Bmin")) )
                                           vars += ("Alpha" -> IntTerm(10))
                                           vars += ("ExponentMin" ->  (vars("Alpha") *  (vars("Demotion") - vars("BenMin")) ) )
                                           vars += ("ExpValMin" -> nl.uva.exp.ExponentCalculator.calculateExponent(vars("ExponentMin")))
                                           vars += ("ScoreMin" ->  (IntTerm(1) /  (IntTerm(1) + vars("ExpValMin")) ) )
                                           vars += ("ExponentMax" ->  (vars("Alpha") *  (vars("Demotion") - vars("BenMax")) ) )
                                           vars += ("ExpValMax" -> nl.uva.exp.ExponentCalculator.calculateExponent(vars("ExponentMax")))
                                           vars += ("ScoreMax" ->  (IntTerm(1) /  (IntTerm(1) + vars("ExpValMax")) ) )
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence_score_min",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence_score_min",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value"),vars("ScoreMin")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence_score_max",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence_score_max",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value"),vars("ScoreMax")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( ( ( ( (StringTerm("Value ") + vars("Value"))  + StringTerm(": demotion="))  + vars("Demotion"))  + StringTerm(", Bmin="))  + vars("Bmin"))  + StringTerm(", Bmax="))  + vars("Bmax"))  + StringTerm(", scoreMin="))  + vars("ScoreMin"))  + StringTerm(", scoreMax="))  + vars("ScoreMax")) )))


                     }


      }

      object adopt_achievement_get_combined_weight_2 extends IGoal {

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
                         vars +=(   "Value" -> params.l_params(0))
                          vars +=(   "CombinedWv" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))),StructTerm("value_weight",Seq[GenericTerm](vars("Value"),vars("Wcontext"))))),StructTerm("is",Seq[GenericTerm](vars("Z"),StructTerm("+",Seq[GenericTerm](vars("Bmin"),StructTerm("/",Seq[GenericTerm](vars("Bmax"),IntTerm(2))))))))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("Y"))))))

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

                                           vars += ("Ben" ->  (vars("Y") + vars("Z")) )
                                           vars += ("Epsilon" -> DoubleTerm(0.01))
                                           vars += ("Wgamma" ->  (IntTerm(1) /  (vars("Ben") + vars("Epsilon")) ) )
                                           vars += ("CombinedWv" ->  (vars("Wgamma") * vars("Wcontext")) )
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("combined_weight",Seq[GenericTerm](vars("Value"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("combined_weight",Seq[GenericTerm](vars("Value"),vars("CombinedWv")))),GoalParser)


                     }


      }

      object adopt_achievement_comp_sum_ben_3 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "Value" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("benevolence_score_min",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value"),vars("ScoreMin"))),StructTerm("benevolence_score_max",Seq[GenericTerm](vars("A"),vars("Offer"),vars("Value"),vars("ScoreMax"))))),StructTerm("combined_weight",Seq[GenericTerm](vars("Value"),vars("CombinedWv"))))),StructTerm("value_weight",Seq[GenericTerm](vars("Value"),vars("Wv"))))),StructTerm("totalbenmin",Seq[GenericTerm](vars("TotalBenMin"))))),StructTerm("totalbenmax",Seq[GenericTerm](vars("TotalBenMax"))))),StructTerm("total_combined_weight",Seq[GenericTerm](vars("TotalW"))))))

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

                                           vars += ("WeightedScoreMin" ->  (vars("CombinedWv") * vars("ScoreMin")) )
                                           vars += ("WeightedScoreMax" ->  (vars("CombinedWv") * vars("ScoreMax")) )
                                           vars += ("SumMin" ->  (vars("TotalBenMin") + vars("WeightedScoreMin")) )
                                           vars += ("SumMax" ->  (vars("TotalBenMax") + vars("WeightedScoreMax")) )
                                           vars += ("NewTotalW" ->  (vars("TotalW") + vars("CombinedWv")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Processing value: ") + vars("Value"))  + StringTerm(" for offer: "))  + vars("Offer")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Current total benevolence min: ") + vars("TotalBenMin"))  + StringTerm(", max: "))  + vars("TotalBenMax")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Adding score for value ") + vars("Value"))  + StringTerm(": scoreMin="))  + vars("ScoreMin"))  + StringTerm(", scoreMax="))  + vars("ScoreMax")) )))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("New total benevolence min: ") + vars("SumMin"))  + StringTerm(", max: "))  + vars("SumMax")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("totalbenmin",Seq[GenericTerm](vars("TotalBenMin")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("totalbenmin",Seq[GenericTerm](vars("SumMin")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("totalbenmax",Seq[GenericTerm](vars("TotalBenMax")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("totalbenmax",Seq[GenericTerm](vars("SumMax")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("total_combined_weight",Seq[GenericTerm](vars("TotalW")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("total_combined_weight",Seq[GenericTerm](vars("NewTotalW")))),GoalParser)


                     }


      }

      object adopt_achievement_comp_total_ben_2 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("totalbenmin",Seq[GenericTerm](vars("SumMin"))),StructTerm("totalbenmax",Seq[GenericTerm](vars("SumMax"))))),StructTerm("total_combined_weight",Seq[GenericTerm](vars("TotalW"))))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("---- Calculating normalized benevolence interval for offer ") + vars("Offer"))  + StringTerm(" ----")) )))
                                           vars += ("NormalizedMin" ->  (vars("SumMin") / vars("TotalW")) )
                                           vars += ("NormalizedMax" ->  (vars("SumMax") / vars("TotalW")) )
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Offer"),vars("_"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Offer"),vars("NormalizedMin"),vars("NormalizedMax")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("NormalizedMin"),vars("NormalizedMax"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("Tagent"),StructTerm("benevolence_offer",Seq[GenericTerm](vars("A"),vars("Goal"),vars("NormalizedMin"),vars("NormalizedMax"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( ( (StringTerm("Normalized benevolence interval for offer ") + vars("Offer"))  + StringTerm(" by "))  + vars("A"))  + StringTerm(": ["))  + vars("NormalizedMin"))  + StringTerm(", "))  + vars("NormalizedMax"))  + StringTerm("]")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("totalbenmin",Seq[GenericTerm](vars("SumMin")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("totalbenmin",Seq[GenericTerm](IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("totalbenmax",Seq[GenericTerm](vars("SumMax")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("totalbenmax",Seq[GenericTerm](IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("total_combined_weight",Seq[GenericTerm](vars("TotalW")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("total_combined_weight",Seq[GenericTerm](IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),vars("NV")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("number_of_values",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),vars("AV")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("accepted_values",Seq[GenericTerm](vars("Offer"),IntTerm(0)))),GoalParser)


                     }


      }

      object adopt_achievement_handle_acceptance_3 extends IGoal {

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
                          vars +=(   "NewPlan" -> params.l_params(1))
                          vars +=(   "OldPlan" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Handling acceptance for ") + vars("A")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("OldPlan")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("NewPlan")))),GoalParser)
                                               val ex_L61992 = executionContext.beliefBase.bufferedQuery( StructTerm("phi",Seq[GenericTerm](vars("A"),vars("L61992"),vars("NewPlan"),vars("_"))) )
                                               while (ex_L61992.hasNext) {
                                                   val sol_L61992 = ex_L61992.next
                                                   if(sol_L61992.result) {
                                                   vars += ("Value" -> sol_L61992.bindings("L61992").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Updating benevolence for accepted value: ") + vars("Value")) )))
                                                                       adopt_achievement_update_benevolence_accept_4.execute(Parameters(List( vars("A") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))

                                                   }
                                               }
                                           vars -= ("Value")


                     }


      }

      object adopt_achievement_handle_rejection_2 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Handling rejection for ") + vars("A")) )))
                                               val ex_L85773 = executionContext.beliefBase.bufferedQuery( StructTerm("reject",Seq[GenericTerm](vars("A"),vars("Offer"),vars("L85773"))) )
                                               while (ex_L85773.hasNext) {
                                                   val sol_L85773 = ex_L85773.next
                                                   if(sol_L85773.result) {
                                                   vars += ("Value" -> sol_L85773.bindings("L85773").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Updating benevolence for rejected value: ") + vars("Value")) )))
                                                                       adopt_achievement_update_benevolence_reject_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value")  )))

                                                   }
                                               }
                                           vars -= ("Value")


                     }


      }

      object adopt_achievement_update_benevolence_reject_3 extends IGoal {

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
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "Value" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("X1"))))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("OldPlan"),vars("X2"))))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))))))

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

                                           vars += ("B" ->  (vars("X2") - vars("X1")) )
                                          if(( (vars("B") < IntTerm(0)) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("Either ") + vars("A"))  + StringTerm(" did not actually reject the offer on the basis of "))  + vars("Value"))  + StringTerm(" or your assessment of his enjoyment of the plans is incorrect.")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("His benevolence will therefore not be updated according to this information."))))

                                          }
                                                               else if(( (vars("B") < vars("Bmin")) ).holds) {
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Your previous assessment of his benevolence seems to have been too high."))))
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),IntTerm(0),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("The offer was rejected on the basis of ") + vars("Value"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is [") + IntTerm(0))  + StringTerm(", "))  + vars("B"))  + StringTerm(">.")) )))

                                                               }

                                           else {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("The offer was rejected on the basis of ") + vars("Value"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is [") + vars("Bmin"))  + StringTerm(", "))  + vars("B"))  + StringTerm(">.")) )))

                                           }


                     }


      }

      object adopt_achievement_update_benevolence_accept_4 extends IGoal {

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
                          vars +=(   "Value" -> params.l_params(1))
                          vars +=(   "NewPlan" -> params.l_params(2))
                          vars +=(   "OldPlan" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("X1"))),StructTerm("phi",Seq[GenericTerm](vars("A"),vars("Value"),vars("OldPlan"),vars("X2"))))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))))))

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

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("One of the relevant values was ") + vars("Value"))  + StringTerm(".")) )))
                                           vars += ("B" ->  (vars("X2") - vars("X1")) )
                                          if(( (vars("B") < IntTerm(0)) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("It seems ") + vars("A"))  + StringTerm(" did not need to sacrifice "))  + vars("Value"))  + StringTerm(" to accept this plan.")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),IntTerm(0),vars("Bmax")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new plan are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + IntTerm(0))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))

                                          }
                                                               else if(( (vars("B") > vars("Bmax")) ).holds) {
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It seems ") + vars("A"))  + StringTerm(" is even more benevolent than you thought was possible.")) )))
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("B"),IntTerm(1)))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new plan are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + vars("B"))  + StringTerm(", "))  + IntTerm(1))  + StringTerm(".")) )))

                                                               }

                                           else {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("B"),vars("Bmax")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new plan are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is [") + vars("B"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(">.")) )))

                                           }


                     }


      }





 }
object benevolence_companion { 
   def create() = new benevolence().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new benevolence(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new benevolence(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new benevolence(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
