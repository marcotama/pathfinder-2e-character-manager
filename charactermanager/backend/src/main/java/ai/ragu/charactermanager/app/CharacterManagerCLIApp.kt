package ai.ragu.charactermanager.app

import ai.ragu.charactermanager.app.CharacterManagerCLIApp.*
import ai.ragu.charactermanager.content.ancestries.AncestryHuman
import ai.ragu.charactermanager.content.classes.alchemist.AlchemistResearchFieldEnum
import ai.ragu.charactermanager.content.classes.alchemist.ClazzAlchemist
import ai.ragu.charactermanager.dto.CharacterDto
import ai.ragu.charactermanager.mapper.CharacterMapper
import ai.ragu.charactermanager.sheet.CharacterSheet
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.jsonSchema.JsonSchema
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator
import org.apache.commons.io.FilenameUtils
import org.slf4j.LoggerFactory
import picocli.CommandLine
import picocli.CommandLine.Mixin
import java.io.FileInputStream
import java.io.FileWriter
import java.io.IOException
import java.lang.invoke.MethodHandles
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

@CommandLine.Command(name = "characterManager", subcommands = [Compile::class, DtoSchema::class, SheetSchema::class, Create::class])
class CharacterManagerCLIApp {
    internal class InputFile {
        @CommandLine.Option(names = ["-i", "--inputFile"], paramLabel = "INPUT_FILE", description = ["The input file"], required = true)
        val path: Path? = null
    }

    internal class OutputDir {
        @CommandLine.Option(names = ["-o", "--output"], paramLabel = "OUTPUT_DIR", description = ["The output directory"], required = true)
        val path: Path? = null
    }

    internal class Help {
        @CommandLine.Option(names = ["-h", "--help"], usageHelp = true, description = ["Show this help message and exit."])
        private val helpRequested = false
    }

    @CommandLine.Command(name = "dtoSchema", description = ["Generate the character DTO JSON schema"])
    internal class DtoSchema {
        @Mixin
        var outputDir: OutputDir? = null

        @Mixin
        var help: Help? = null
    }

    @CommandLine.Command(name = "sheetSchema", description = ["Generate the character sheet JSON schema"])
    internal class SheetSchema {
        @Mixin
        var outputDir: OutputDir? = null

        @Mixin
        var help: Help? = null
    }

    @CommandLine.Command(name = "compile", description = ["Compile the given character in the sheet JSON format"])
    internal class Compile {
        @Mixin
        var inputFile: InputFile? = null

        @Mixin
        var outputDir: OutputDir? = null

        @Mixin
        var help: Help? = null
    }

    @CommandLine.Command(name = "create", description = ["Create a new character and store it in the DTO JSON format"])
    internal class Create {
        @Mixin
        var outputDir: OutputDir? = null

        @CommandLine.Option(names = ["--characterName"], paramLabel = "CHARACTER_NAME", description = ["The name of the new character"], required = true)
        val characterName: String? = null

        @Mixin
        var help: Help? = null
    }

    @Mixin
    private val help: Help? = null

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
        private val app = CharacterManagerCLIApp()
        const val DEFAULT_TIME_LIMIT_MINUTES = 10
        private const val DATE_TIME_PATTERN = "yyyy-MM-dd-HH-mm-ss"

        /**
         * The entry point. The method parses command line arguments and executes the appropriate actions.
         *
         * @param args the command line args, as an array of strings
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val commandLine = CommandLine(app)
            val parseResult: CommandLine.ParseResult
            parseResult = try {
                commandLine.parseArgs(*args)
            } catch (e: Exception) {
                logger.error(e.localizedMessage)
                return
            }
            handleParseResult(parseResult)
        }

        /**
         * Executes the appropriate command instructed in the command line arguments.
         *
         * @param parseResult the parsed command line arguments, as generated by PicoCLI
         */
        private fun handleParseResult(parseResult: CommandLine.ParseResult) {
            for (parsed in parseResult.asCommandLineList()) {
                if (parsed.isUsageHelpRequested) {
                    parsed.usage(System.out)
                    return
                } else if (parsed.isVersionHelpRequested) {
                    parsed.printVersionHelp(System.out)
                    return
                }
            }
            val subCommand = parseResult.subcommand()
            when (subCommand.commandSpec().userObject().javaClass) {
                Compile::class.java -> {
                    val compile = subCommand.commandSpec().userObject() as Compile
                    createOutputDirectory(compile.outputDir!!.path!!)
                    val inputFilePath = compile.inputFile!!.path
                    val noExtName = FilenameUtils.removeExtension(compile.inputFile!!.path!!.toFile().name)
                    val outputFilePath = Path.of(compile.outputDir!!.path.toString(), "$noExtName.sheet.json")
                    compileCharacter(inputFilePath, outputFilePath)
                }
                DtoSchema::class.java -> {
                    val dtoSchema = subCommand.commandSpec().userObject() as DtoSchema
                    createOutputDirectory(dtoSchema.outputDir!!.path!!)
                    val outputFilePath = Path.of(dtoSchema.outputDir!!.path.toString(), "dto-schema.json")
                    generateSchema(CharacterSheet::class.java, outputFilePath)
                }
                SheetSchema::class.java -> {
                    val sheetSchema = subCommand.commandSpec().userObject() as SheetSchema
                    createOutputDirectory(sheetSchema.outputDir!!.path!!)
                    val outputFilePath = Path.of(sheetSchema.outputDir!!.path.toString(), "sheet-schema.json")
                    generateSchema(CharacterSheet::class.java, outputFilePath)
                }
                Create::class.java -> {
                    val create = subCommand.commandSpec().userObject() as Create
                    createOutputDirectory(create.outputDir!!.path!!)
                    val outputFilePath = Path.of(create.outputDir!!.path.toString(), String.format("%s.json", create.characterName))
                    createNewCharacter(create.characterName, outputFilePath)
                }
            }
        }

        /**
         * Compiles a character DTO into its sheet representation.
         *
         * @param inputFilePath the full path to the character DTO JSON file to read
         * @param outputFilePath the full path to the character sheet JSON file to write
         */
        private fun compileCharacter(inputFilePath: Path?, outputFilePath: Path) {
            logger.info("Compiling the character into sheet JSON format...")
            var characterDto: CharacterDto
            try {
                FileInputStream(inputFilePath!!.toFile()).use { fileStream ->
                    val objectMapper = ObjectMapper()
                    characterDto = objectMapper.readValue(fileStream, CharacterDto::class.java)
                    logger.info(String.format("Character JSON file loaded: %s", inputFilePath))
                }
                val characterSheet: CharacterSheet = CharacterMapper.Companion.INSTANCE.map(characterDto)
                FileWriter(outputFilePath.toFile()).use { file ->
                    val objectMapper = ObjectMapper()
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, characterSheet)
                    logger.info(String.format("Character sheet JSON file generated: %s", outputFilePath.toFile()))
                }
            } catch (exception: IOException) {
                logger.error(exception.localizedMessage)
            }
        }

        /**
         * Creates a blank new character with the given name.
         *
         * @param characterName the name of the new character
         * @param outputFilePath the full path to the character sheet JSON file to write
         */
        private fun createNewCharacter(characterName: String?, outputFilePath: Path) {
            logger.info("Compiling the character into sheet JSON format...")
            val characterDto = CharacterDto()
            characterDto.id = UUID.randomUUID()
            characterDto.setName(characterName)
            characterDto.ancestry = AncestryHuman()
            characterDto.clazz = ClazzAlchemist()
            val researchFieldChoice = characterDto.clazz.getChoices(1)[1]
            researchFieldChoice.answers = List.of<String>(AlchemistResearchFieldEnum.BOMBER.toString())
            println(researchFieldChoice.callback(characterDto)[0].options)
            try {
                FileWriter(outputFilePath.toFile()).use { file ->
                    val objectMapper = ObjectMapper()
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, characterDto)
                    logger.info(String.format("Character sheet JSON file generated: %s", outputFilePath.toFile()))
                }
            } catch (exception: IOException) {
                logger.error(exception.localizedMessage)
            }
        }

        /**
         * Generates the JSON schema for the given class (assuming the proper annotations are present).
         *
         * @param cls the class of which the schema should be generated
         * @param outputFilePath the full path to the JSON schema file to write
         */
        private fun generateSchema(cls: Class<*>, outputFilePath: Path) {
            val mapper = ObjectMapper()
            val generator = JsonSchemaGenerator(mapper)
            var jsonSchema: JsonSchema? = null
            try {
                jsonSchema = generator.generateSchema(cls)
            } catch (e: JsonMappingException) {
                logger.error(e.localizedMessage)
            }
            try {
                FileWriter(outputFilePath.toString()).use { file ->
                    logger.info("Generating sheet schema...")
                    val obj = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema)
                    file.write(obj)
                    logger.info(String.format("Schema generated in: %s", outputFilePath))
                }
            } catch (exception: IOException) {
                logger.error(exception.localizedMessage)
            }
        }

        private fun createOutputDirectory(targetPath: Path) {
            if (!Files.exists(targetPath)) {
                try {
                    Files.createDirectories(targetPath)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}